# Roman Numeral Math API - Ruby Gem

Roman Numeral Math computes addition, subtraction, multiplication, and division between two Roman numerals. It returns the calculated result and complete equation in both Roman numeral and standard integer formats.

## Installation

Add this line to your application's Gemfile:

```ruby
gem 'apiverve_romannumeralmath'
```

And then execute:

```bash
$ bundle install
```

Or install it yourself as:

```bash
$ gem install apiverve_romannumeralmath
```

## Getting Started

Get your API key at [APIVerve](https://apiverve.com)

### Basic Usage

```ruby
require 'apiverve_romannumeralmath'

# Initialize the client
client = APIVerve::Romannumeralmath::Client.new(api_key: "YOUR_API_KEY")

# Make a request
response = client.execute({
  roman1: "XIV",
  roman2: "VI",
  operation: "add"
})

# Print the response
puts response
```


### Error Handling

```ruby
begin
  response = client.execute({ roman1: "XIV", roman2: "VI", operation: "add" })
  puts response["data"]
rescue APIVerve::Romannumeralmath::ValidationError => e
  puts "Validation error: #{e.errors.join(', ')}"
rescue APIVerve::Romannumeralmath::APIError => e
  puts "API error: #{e.message}"
  puts "Status code: #{e.status_code}"
end
```

### Debug Mode

```ruby
# Enable debug logging
client = APIVerve::Romannumeralmath::Client.new(
  api_key: "YOUR_API_KEY",
  debug: true
)
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

## Documentation

For more information, visit the [API Documentation](https://docs.apiverve.com/ref/romannumeralmath?utm_source=rubygems&utm_medium=referral&utm_content=readme).

## Support

- Website: [https://apiverve.com/marketplace/romannumeralmath?utm_source=ruby&utm_medium=referral&utm_content=readme](https://apiverve.com/marketplace/romannumeralmath?utm_source=ruby&utm_medium=referral&utm_content=readme)
- Email: hello@apiverve.com

## License

This gem is available under the [MIT License](LICENSE).
