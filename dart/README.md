# Roman Numeral Math API - Dart/Flutter Client

Roman Numeral Math computes addition, subtraction, multiplication, and division between two Roman numerals. It returns the calculated result and complete equation in both Roman numeral and standard integer formats.

[![pub package](https://img.shields.io/pub/v/apiverve_romannumeralmath.svg)](https://pub.dev/packages/apiverve_romannumeralmath)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

This is the Dart/Flutter client for the [Roman Numeral Math API](https://apiverve.com/marketplace/romannumeralmath?utm_source=dart&utm_medium=referral&utm_content=readme).

## Installation

Add this to your `pubspec.yaml`:

```yaml
dependencies:
  apiverve_romannumeralmath: ^1.2.6
```

Then run:

```bash
dart pub get
# or for Flutter
flutter pub get
```

## Usage

```dart
import 'package:apiverve_romannumeralmath/apiverve_romannumeralmath.dart';

void main() async {
  final client = RomannumeralmathClient('YOUR_API_KEY');

  try {
    final response = await client.execute({
      'roman1': 'XIV',
      'roman2': 'VI',
      'operation': 'add'
    });

    print('Status: ${response.status}');
    print('Data: ${response.data}');
  } catch (e) {
    print('Error: $e');
  }
}
```

## Response

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

## API Reference

- **API Home:** [Roman Numeral Math API](https://apiverve.com/marketplace/romannumeralmath?utm_source=dart&utm_medium=referral&utm_content=readme)
- **Documentation:** [docs.apiverve.com/ref/romannumeralmath](https://docs.apiverve.com/ref/romannumeralmath?utm_source=dart&utm_medium=referral&utm_content=readme)

## Authentication

All requests require an API key. Get yours at [apiverve.com](https://apiverve.com?utm_source=dart&utm_medium=referral&utm_content=readme).

## License

MIT License - see [LICENSE](LICENSE) for details.

---

Built with Dart for [APIVerve](https://apiverve.com?utm_source=dart&utm_medium=referral&utm_content=readme)
