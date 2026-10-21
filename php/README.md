# Roman Numeral Math API - PHP Package

Roman Numeral Math computes addition, subtraction, multiplication, and division between two Roman numerals. It returns the calculated result and complete equation in both Roman numeral and standard integer formats.

## Installation

Install via Composer:

```bash
composer require apiverve/romannumeralmath
```

## Getting Started

Get your API key at [APIVerve](https://apiverve.com)

### Basic Usage

```php
<?php

require_once 'vendor/autoload.php';

use APIVerve\Romannumeralmath\Client;

// Initialize the client
$client = new Client('YOUR_API_KEY');

// Make a request
$response = $client->execute([
    'roman1' => 'XIV',
    'roman2' => 'VI',
    'operation' => 'add'
]);

// Print the response
print_r($response);
```


### Error Handling

```php
use APIVerve\Romannumeralmath\Client;
use APIVerve\Romannumeralmath\Exceptions\APIException;
use APIVerve\Romannumeralmath\Exceptions\ValidationException;

try {
    $response = $client->execute(['roman1' => 'XIV', 'roman2' => 'VI', 'operation' => 'add']);
    print_r($response['data']);
} catch (ValidationException $e) {
    echo "Validation error: " . implode(', ', $e->getErrors());
} catch (APIException $e) {
    echo "API error: " . $e->getMessage();
    echo "Status code: " . $e->getStatusCode();
}
```

### Debug Mode

```php
// Enable debug logging
$client = new Client(
    apiKey: 'YOUR_API_KEY',
    debug: true
);
```

## Example Response

```json
{
  "status": "ok",
  "error": null,
  "data": {
    "roman1": "XIV",
    "roman2": "VI",
    "roman1_value": 14,
    "roman2_value": 6,
    "operation": "add",
    "result_number": 20,
    "result_roman": "XX",
    "equation_numeric": "14 + 6 = 20",
    "equation_roman": "XIV + VI = XX"
  }
}
```

## Requirements

- PHP 7.4 or higher
- Guzzle HTTP client

## Documentation

For more information, visit the [API Documentation](https://docs.apiverve.com/ref/romannumeralmath?utm_source=packagist&utm_medium=referral&utm_content=readme).

## Support

- Website: [https://apiverve.com/marketplace/romannumeralmath?utm_source=php&utm_medium=referral&utm_content=readme](https://apiverve.com/marketplace/romannumeralmath?utm_source=php&utm_medium=referral&utm_content=readme)
- Email: hello@apiverve.com

## License

This package is available under the [MIT License](LICENSE).
