# frozen_string_literal: true

Gem::Specification.new do |spec|
  spec.name          = "apiverve_romannumeralmath"
  spec.version       = "1.2.2"
  spec.authors       = ["APIVerve"]
  spec.email         = ["hello@apiverve.com"]

  spec.summary       = "Roman Numeral Math API - Ruby Client"
  spec.description   = "Roman Numeral Math computes addition, subtraction, multiplication, and division between two Roman numerals. It returns the calculated result and complete equation in both Roman numeral and standard integer formats."
  spec.homepage      = "https://apiverve.com/marketplace/romannumeralmath?utm_source=ruby&utm_medium=referral&utm_content=homepage"
  spec.license       = "MIT"
  spec.required_ruby_version = ">= 2.7.0"

  spec.metadata["homepage_uri"] = spec.homepage
  spec.metadata["source_code_uri"] = "https://github.com/apiverve/romannumeralmath-API/tree/main/ruby"
  spec.metadata["changelog_uri"] = "https://apiverve.com/changelog"
  spec.metadata["documentation_uri"] = "https://docs.apiverve.com/ref/romannumeralmath"

  spec.files = Dir.glob("{lib}/**/*") + %w[README.md LICENSE]
  spec.require_paths = ["lib"]

  spec.add_dependency "faraday", ">= 1.0", "< 3.0"
  spec.add_dependency "faraday-multipart", "~> 1.0"
  spec.add_dependency "json", "~> 2.0"
end
