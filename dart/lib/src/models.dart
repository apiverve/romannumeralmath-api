/// Response models for the Roman Numeral Math API.

/// API Response wrapper.
class RomannumeralmathResponse {
  final String status;
  final dynamic error;
  final RomannumeralmathData? data;

  /// Set only when the current plan locks one or more fields; null otherwise.
  final PremiumInfo? premium;

  RomannumeralmathResponse({
    required this.status,
    this.error,
    this.data,
    this.premium,
  });

  factory RomannumeralmathResponse.fromJson(Map<String, dynamic> json) => RomannumeralmathResponse(
    status: json['status'] as String? ?? '',
    error: json['error'],
    data: json['data'] != null ? RomannumeralmathData.fromJson(json['data']) : null,
    premium: json['premium'] != null ? PremiumInfo.fromJson(json['premium']) : null,
  );

  Map<String, dynamic> toJson() => {
    'status': status,
    if (error != null) 'error': error,
    if (data != null) 'data': data,
    if (premium != null) 'premium': premium!.toJson(),
  };
}

/// Describes fields the current plan does not unlock. Locked fields arrive as null
/// in [data], and [lockedFields] names them (nested ones use dot paths).
class PremiumInfo {
  final String? message;
  final String? upgradeUrl;
  final List<String>? lockedFields;

  PremiumInfo({this.message, this.upgradeUrl, this.lockedFields});

  factory PremiumInfo.fromJson(Map<String, dynamic> json) => PremiumInfo(
    message: json['message'] as String?,
    upgradeUrl: json['upgrade_url'] as String?,
    lockedFields: (json['locked_fields'] as List?)?.map((e) => e.toString()).toList(),
  );

  Map<String, dynamic> toJson() => {
    if (message != null) 'message': message,
    if (upgradeUrl != null) 'upgrade_url': upgradeUrl,
    if (lockedFields != null) 'locked_fields': lockedFields,
  };
}

/// Response data for the Roman Numeral Math API.

class RomannumeralmathData {
  String? roman1;
  String? roman2;
  num? roman1Value;
  num? roman2Value;
  String? operation;
  num? resultNumber;
  String? resultRoman;
  String? equationNumeric;
  String? equationRoman;

  RomannumeralmathData({
    this.roman1,
    this.roman2,
    this.roman1Value,
    this.roman2Value,
    this.operation,
    this.resultNumber,
    this.resultRoman,
    this.equationNumeric,
    this.equationRoman,
  });

  factory RomannumeralmathData.fromJson(Map<String, dynamic> json) => RomannumeralmathData(
      roman1: json['roman1'],
      roman2: json['roman2'],
      roman1Value: json['roman1_value'],
      roman2Value: json['roman2_value'],
      operation: json['operation'],
      resultNumber: json['result_number'],
      resultRoman: json['result_roman'],
      equationNumeric: json['equation_numeric'],
      equationRoman: json['equation_roman'],
    );
}

class RomannumeralmathRequest {
  String roman1;
  String roman2;
  String? operation;

  RomannumeralmathRequest({
    required this.roman1,
    required this.roman2,
    this.operation,
  });

  Map<String, dynamic> toJson() => {
      'roman1': roman1,
      'roman2': roman2,
      if (operation != null) 'operation': operation,
    };
}
