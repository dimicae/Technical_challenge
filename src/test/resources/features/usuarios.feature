#language: es
#encoding: iso-8859-1
Caracter�stica: Usuarios
  Como administrador de la plataforma ReqRes
  quiero crear, modificar, consultar y eliminar usuarios
  para mantener el registro de usuarios de la plataforma actualizado

  Antecedentes: consumir servicio usuarios
    Dado que el usuario consume el servicio

  @crearUsuario
  Esquema del escenario: Crear usuario
    Cuando se crea un nuevo usuario con nombre '<nombre>' y con el rol '<rol>'
    Entonces el usuario quedar� creado exitosamente

    Ejemplos:
      | nombre | rol   |
      | lucas  | lider |
