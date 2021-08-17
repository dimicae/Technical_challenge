#language: es
#encoding: iso-8859-1
Caracter�stica: Simulador
  Como usuario de la p�gina web de la HAUS
  quiero simular el pago de un cr�dito
  para conocer el valor de la cuota mensual a pagar

  @simulador
  Esquema del escenario: Calcular el pago de una vivienda
    Dado que el usuario ingres� al simulador de pago de vivienda de la haus "Colombia"
    Cuando el simula el valor de un cr�dito, con los datos:
      | valorPropiedad   | valorCredito   | plazo   | tasa   |
      | <valorPropiedad> | <valorCredito> | <plazo> | <tasa> |
    Entonces el deber�a ver el valor de su cuota

    Ejemplos:
      | valorPropiedad | valorCredito | plazo | tasa |
      | 100000000      | 60000000     | 10    | 9    |