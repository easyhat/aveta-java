# Aveta

Aveta is a Java library for formatting large numbers into a more readable format with optional units. It's designed to be flexible and customizable, allowing you to format numbers with various options.

## Features

- Format large numbers with K, M, B, T suffixes (or custom units)
- Customize decimal places and precision
- Option for lowercase units
- Customizable separator between number and unit
- Option to add space between number and unit
- Chainable option setting

## Usage

Here's a basic example of how to use Aveta:

```java
System.out.println(Aveta.format(8700));  // Output: 8.7K
```

You can customize the formatting using the `Options` class:

```java
System.out.println(Aveta.format(123456, new Aveta.Options()
        .setDigits(3)
        .setLowercase(true)));  // Output: 123.456k

System.out.println(Aveta.format(2048000, new Aveta.Options()
        .setPrecision(2)
        .setLowercase(true)));  // Output: 2.05m

System.out.println(Aveta.format(45500, new Aveta.Options()
        .setPrecision(3)
        .setSeparator(",")));  // Output: 45.500,K

System.out.println(Aveta.format(1440000, new Aveta.Options()
        .setUnits(Arrays.asList("B", "KB", "MB", "GB", "TB"))
        .setSpace(true)));  // Output: 1.44 MB
```

## Options

- `setDigits(int)`: Set the maximum number of decimal places (default: 1)
- `setLowercase(boolean)`: Use lowercase units (default: false)
- `setPrecision(int)`: Set a fixed number of decimal places (-1 for auto)
- `setSeparator(String)`: Set a custom separator between number and unit
- `setSpace(boolean)`: Add a space between number and unit (default: false)
- `setUnits(List<String>)`: Set custom units
