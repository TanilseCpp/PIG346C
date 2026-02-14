/*
==================================================
-Las tablas
-Relaciones entre tablas

El objetivo es represetar un sistema de 
gestion de produccion y consumo energetico
con audoria de usuario
==================================================
*/

/*
Tabla: country
Funcion:
-Tabla maestra
-Almacena los paises donde opera el sistema
-Evita duplicar nombres de paises en otras tablas
-Punto raiz del modelo gegrafico
-------------------------------------------------
*/
Table country {
  id integer [primary key] //Identificador unico
  name varchar [unique] //Nombre del pais
}


/*
-------------------------------------------------
Tabla: region
Funcion:
-Representar regiones o departamentos de un pais
-Depende directamente de la tabla country
-Permite realizar geograficos mas detallados
-------------------------------------------------
*/
Table region {
  id integer [primary key]
  name varchar
  country_id integer [not null] //FK hacia country
indexes {
  (name, country_id) [unique] //Region unica por pais
}
}


/*
-------------------------------------------------
Tabla: company
Funcion:
-Representa empresa generadoras o gestoras de energia
-Cada empresa pertenece a un pais
-Permite agrupar por empresa
-------------------------------------------------
*/
Table company {
  id integer [primary key]
  name varchar
  country_id integer [not null] //FK hacia country
indexes {
  (name, country_id) [unique] //Empresa unica por pais
}
}


/*
-------------------------------------------------
Tabla: energy_type
Funcion:
-Tabla cataloo de tipos de eneria
Ejemplo: solar, eolica, hifraulica, termica
-Permite clsificar las plantas por tipo de energia
-------------------------------------------------
*/
Table energy_type {
  id integer [primary key]
  name varchar [unique]
  renewable boolean //Indica si es energia renovable
}


/*
-------------------------------------------------
Tabla: power_plant
Funcion:
-Entidad central del sistema
-Representa una planta generadora de energia
-Conecta empresa, region y tipo de energia
-------------------------------------------------
*/
Table power_plant {
  id integer [primary key]
  name varchar
  company_id integer [not null] //FK hacia country
  region_id integer [not null] //FK hacia region
  energy_type_id integer [not null] //FK hacia energy_type
indexes {
  (name, company_id) [unique] //Planta unica por empresa
}
}


/*
-------------------------------------------------
Tabla: measurement_type
Funcion:
-Define los tipos de medicion energetica
Ejemplos: produccion, consumo, capacidad instalada
-Separa el tipo de dato del valor medido
-------------------------------------------------
*/
Table measurement_type {
  id integer [primary key]
  name varchar [unique]
  unit varchar // Unidad de medida(Kwh, Mwh, Gwh)
}


/*
-------------------------------------------------
Tabla: energy_record
Funcion:
-Tabla transaccional
-Almacena los valores historicos de energia es la
base para reportes y analisis
-------------------------------------------------
*/
Table energy_record {
  id bigint [primary key]
  year integer
  month integer
  value decimal // Valor energetico medido
  power_plant_id integer [not null] //FK hacia power_plant
  measurement_type_id integer [not null] //FK hacia measurement_type
indexes {
  (power_plant_id, year, month, measurement_type_id) [unique]
}
}

/*
Define el tipo de Enum
*/
Enum Role {
  admin
  user
  analyst
}
/*
-------------------------------------------------
Tabla: users
Funcion:
-Representa los usuarios del sistema
-Gestion, autentificacion y roles
-No pertenece al dominio energetico
-------------------------------------------------
*/
Table users {
  id integer [primary key]
  username varchar [unique]
  role Role // Enum: admin, analyst, user
  email varchar [unique]
  password varchar
  created_at timestamp // Fecha de creacion
  updated_at timestamp // Fecha de modificacion
}


/*
-------------------------------------------------
Tabla: audit_log
Funcion:
-Tabla de auditoria
-Registra acciones realizadas por los usuarios
-Garantiza trazabilidad y control
-------------------------------------------------
*/
Table audit_log {
  id bigint [primary key]
  action varchar //Accion realizada
  action_date timestamp // Fecha de accion
  user_id integer [not null] // FK hacia users
}


/*
==================================================
Relaciones entre tablas
==================================================
*/

/*
-Relacion geografica:
Muchas regiones pertenecen a un pais
Pais -> Region (si se borra pais, se borran regiones)
*/
Ref: region.country_id > country.id [delete: cascade]

/*
-Relacion empresarial:
Muchas empresas pertenecen a un pais
Pais -> empresa
*/
Ref: company.country_id > country.id [delete: cascade]

/*
-Relacion centrales de la planta generadora:
Cada planta pertenece a una empresa, region y tipo
de energia
Empresa -> Planta , Region -> Planta , Tipo de energia -> Planta
*/
Ref: power_plant.company_id > company.id [delete: cascade]
Ref: power_plant.region_id > region.id [delete: cascade]
Ref: power_plant.energy_type_id > energy_type.id [delete: cascade]

/*
-Relacion transaccional:
Muchos registros energeticos pertenecen a una
planta y a un tipo de mediion
*/
Ref: energy_record.power_plant_id > power_plant.id
Ref: energy_record.measurement_type_id > measurement_type.id

/*
-Relacion de auditoria:
Un usuario puede 
*/
Ref: audit_log.user_id > users.id