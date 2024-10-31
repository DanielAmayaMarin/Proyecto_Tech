

DROP PROCEDURE IF EXISTS GetObtenerMetricasPrincipales;
CALL GetObtenerMetricasPrincipales(2021);


-- 1. CARDS PRINCIPALES
-- Nombre: Métricas Principales del Dashboard
DELIMITER //

CREATE PROCEDURE GetObtenerMetricasPrincipales(IN anio INTEGER)
BEGIN
    SELECT
        SUM(pe.cantidad_gwh) as produccion_total,
        (SELECT SUM(consumo_total_gwh) FROM consumoenergia WHERE anio = anio) as consumo_total,
        ROUND((SUM(pe.cantidad_gwh) / (SELECT SUM(consumo_total_gwh) FROM consumoenergia WHERE anio = anio) * 100), 1) as eficiencia
    FROM produccionenergia pe
    WHERE pe.anio = anio;
END //

DELIMITER ;


-- 2. GRÁFICA: Producción vs Consumo (Línea)
-- Nombre: Tendencia de Producción y Consumo
SELECT pe.anio,pe.mes,SUM(pe.cantidad_gwh) as produccion,SUM(ce.consumo_total_gwh) as consumo
FROM produccionenergia pe
JOIN consumoenergia ce ON pe.pais_id = ce.pais_id AND pe.anio = ce.anio AND pe.mes = ce.mes
WHERE pe.anio = 2000 GROUP BY pe.anio, pe.mes ORDER BY pe.anio, pe.mes;


-- 3. GRÁFICA: Fuentes de Energía Renovable (Circular)
-- Nombre: Distribución de Fuentes Renovables

DROP PROCEDURE IF EXISTS GetFuentesDeEnergiaRenovable;
CALL GetFuentesDeEnergiaRenovable()

DELIMITER //

CREATE PROCEDURE GetFuentesDeEnergiaRenovable()
BEGIN
    SELECT te.nombre as tipo_energia,SUM(pe.cantidad_gwh) as cantidad,ROUND(SUM(pe.cantidad_gwh) * 100.0 / (
        SELECT SUM(cantidad_gwh) FROM produccionenergia pe2 JOIN tiposenergia te2 ON pe2.tipo_energia_id = te2.id WHERE te2.es_renovable = 1
    ), 1) as porcentaje
	FROM produccionenergia pe
	JOIN tiposenergia te ON pe.tipo_energia_id = te.id
	WHERE te.es_renovable = 1
	GROUP BY te.nombre
	ORDER BY cantidad DESC;
END //

DELIMITER ;



-- 5. GRÁFICA: Tendencia de Producción (Línea)
-- Nombre: Tendencia Mensual de Producción
DROP PROCEDURE IF EXISTS GetTendenciaMensualDeProduccion;
CALL GetTendenciaAnualDeProduccion()

DELIMITER //

CREATE PROCEDURE GetTendenciaAnualDeProduccion()
BEGIN
    SELECT anio, SUM(cantidad_gwh) as produccion_total FROM produccionenergia GROUP BY anio ORDER BY anio;
END //

DELIMITER ;

-- 4. GRÁFICA: Producción de Energía
-- Nombre: Producción por Energía

DROP PROCEDURE IF EXISTS GetProduccionPorEnergia;
CALL GetProduccionPorEnergia()

DELIMITER //

CREATE PROCEDURE GetProduccionPorEnergia()
BEGIN
    SELECT
    pe.anio,
    p.nombre AS pais,
    pe.mes,
    pe.cantidad_gwh as valor,
    te.nombre as tipo_energia
FROM produccionenergia pe
JOIN paises p ON pe.pais_id = p.id
JOIN tiposenergia te ON pe.tipo_energia_id = te.id
GROUP BY
    pe.anio,
    p.nombre,
    pe.mes,
    pe.cantidad_gwh,
    te.nombre
ORDER BY
    pe.anio,
    p.nombre,
    pe.mes;
END //

DELIMITER ;


CREATE SCHEMA `energia_transicion_on` DEFAULT CHARACTER SET utf8 COLLATE utf8_spanish_ci ;

USE energia_transicion_on;


-- Primero creamos las tablas base sin relaciones
CREATE TABLE continentes (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) UNIQUE NOT NULL
);

CREATE TABLE paises (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    continente_id INT,
    poblacion BIGINT,
    area_km2 FLOAT,
    UNIQUE(nombre),
    FOREIGN KEY (continente_id) REFERENCES continentes(id)
);

CREATE TABLE tiposenergia (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    es_renovable BOOLEAN DEFAULT true,
    descripcion TEXT,
    UNIQUE(nombre)
);

CREATE TABLE produccionenergia (
    id INT AUTO_INCREMENT PRIMARY KEY,
    pais_id INT,
    tipo_energia_id INT,
    anio INT NOT NULL,
    mes INT NOT NULL,
    cantidad_gwh FLOAT NOT NULL,
    capacidad_instalada_mw FLOAT,
    factor_capacidad FLOAT,
    fecha_registro TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CHECK (mes BETWEEN 1 AND 12),
    CHECK (anio >= 1900),
    FOREIGN KEY (pais_id) REFERENCES paises(id),
    FOREIGN KEY (tipo_energia_id) REFERENCES tipos_energia(id)
);

CREATE TABLE consumoenergia (
    id INT AUTO_INCREMENT PRIMARY KEY,
    pais_id INT,
    anio INT NOT NULL,
    mes INT NOT NULL,
    consumo_total_gwh FLOAT NOT NULL,
    consumo_renovable_gwh FLOAT,
    consumo_industrial_gwh FLOAT,
    consumo_residencial_gwh FLOAT,
    consumo_comercial_gwh FLOAT,
    fecha_registro TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CHECK (mes BETWEEN 1 AND 12),
    CHECK (anio >= 1900),
    FOREIGN KEY (pais_id) REFERENCES paises(id)
);