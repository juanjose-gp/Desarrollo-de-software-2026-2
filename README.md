# Sistema Bancario y Procesamiento de Pagos en Java

## Descripción

Este proyecto desarrolla un sistema bancario básico en Java aplicando conceptos fundamentales de Programación Orientada a Objetos (POO):

- Encapsulación
- Herencia
- Polimorfismo
- Interfaces
- Manejo de excepciones
- Colecciones (List)
- Validación de datos

El sistema permite administrar múltiples cuentas bancarias y realizar compras utilizando diferentes métodos de pago.

---

# Tecnologías utilizadas

- Java
- BigDecimal para manejo preciso de montos monetarios
- Scanner para entrada de datos por consola
- Colecciones Java (`ArrayList`)

---

# Funcionalidades

## 1. Creación de cuentas

El sistema permite crear dos tipos de cuentas:

### Cuenta de ahorro

- Número de cuenta
- Titular
- Saldo inicial

### Cuenta corriente

- Número de cuenta
- Titular
- Saldo inicial
- Límite de descubierto

---

## 2. Validaciones implementadas

### Número de cuenta

Debe cumplir las siguientes reglas:

- Solo números
- Mínimo 6 dígitos
---

### Titular

Debe contener:

- Solo letras
- Se permiten espacios

### Saldo inicial

- No puede ser negativo

### Montos de transacciones

Los montos:

- Deben ser positivos
- No pueden ser cero
- No pueden ser nulos

# Gestión de cuentas

Las cuentas creadas se almacenan temporalmente en memoria mediante:

```java
List<Cuenta> cuentas
```

Esto permite:

- Tener múltiples cuentas registradas
- Consultarlas durante la ejecución del programa
- Operar sobre ellas

Las cuentas se eliminan automáticamente al cerrar la aplicación.

---

# Depósitos

Permite adicionar dinero a una cuenta existente.

Ejemplo:

```text
Saldo inicial: 100000
Depósito: 20000
Saldo final: 120000
```

---

# Débitos

Permite retirar dinero de una cuenta.

### Cuenta de ahorro

Solo puede retirar hasta el saldo disponible.
---

### Cuenta corriente

Permite utilizar el monto de presto limite configurado.


# Consulta de cuentas

El sistema muestra todas las cuentas registradas:

```text
Cuenta{numero='123456', titular='Juan', saldo=50000}
Cuenta{numero='654321', titular='Jose', saldo=80000}
```

---

## Pago en efectivo

```java
PagoEfectivo
```

Registro de pagos realizados en efectivo.

---

## Pago con tarjeta

```java
PagoTarjeta
```

Solicita:

```text
Número de tarjeta
```

Procesa la compra utilizando dicha tarjeta.


---

# Excepciones personalizadas

El sistema implementa:

```java
SaldoInsuficienteException
```

Se lanza cuando una operación intenta retirar más dinero del permitido.

---

# Menú principal

```text
      MENÚ 

1. Crear cuenta
2. Depositar
3. Debitar
4. Ver saldo
5. Hacer compra
0. Salir
```

---


---

