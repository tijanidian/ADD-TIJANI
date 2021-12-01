# UT-02 Ex-04 Clientes y Facturas

Desarrolla una aplicación que permita trabajar con **SharedPreferences*. Queremos persistir
información sobre clientes y facturas de clientes. Una factura está asociada a un cliente. Una
factura puede tener de 1 a N líneas de facturas. Cada línea de factura tendrá sólo un producto.

Para ello, debes implementar lo siguiente:

- La clase CustomerLocalData se gestionará en un fichero SharedPreferences (xml) **
  encriptado**.
- La clase InvoiceLocalData se gestionará en un fichero SharedPreferences (xml)
- Una clase principal (Activity) que permita probar que todo funciona correctamente.

Nota: La clase CustomerLocalData y InvoiceLocalData, y el fichero Models no pueden ser modificadas.

## Documentación a entregar

- Hay que crear una rama llamada: ``ut02_ex04_sharedpref`` que salga de **develop**.
- Se creará una **Pull Request** con la solución propuesta añadiendo información útil.
- Me pondrá como revisor.

## Objetivo contextualizado

RA-01(completo): Desarrollar aplicaciones que gestionen información almacenada en ficheros y en
ficheros xml usando SharedPreferences.

## Criterios de Evaluación contextualizados

- [x] El alumno sabe crear ficheros.
- [x] El alumno sabe eliminar ficheros.
- [x] El alumno sabe actualizar la información en un fichero.
- [x] El alumno sabe leer información de un fichero.
- [x] El alumno sabe crear ficheros en la caché o de forma general.
- [x] El alumno sabe cuando usar ficheros en caché o de forma general.
- [x] El alumno sabe serializar un modelo de datos para almacenarlo en ficheros.
- [x] El alumno sabe documentar el trabajo realizado en una Pull Request.
- [x] El alumno sabe recuperar información almacenada en un SharedPreferences.
- [x] El alumno sabe almacenar información en un SharedPreferences.
- [x] El alumno sabe serializar un objeto para almacenarlo en SharedPreferences y viceversa,
  convierte a modelo información obtenida de SharedPreferences.
- [x] El alumno documenta en una PR el código desarrollado.
- [x] El alumno sabe gestionar los errores con Result.

## Otros conceptos evaluables

- Se valorarán los [siguientes conceptos](../../../../../../../../../) como contenido extra que **
  aporta calidad** al código realizado.

## Referencias bibliográficas

- [Consulta el README de la Unidad de Trabajo](../)