declare module '@apiverve/romannumeralmath' {
  export interface romannumeralmathOptions {
    api_key: string;
    secure?: boolean;
  }

  /**
   * Describes fields the current plan does not unlock. Locked fields arrive as null
   * in `data`; `locked_fields` names them, using dot paths for nested fields.
   * Absent when the plan unlocks everything.
   */
  export interface PremiumInfo {
    message: string;
    upgrade_url: string;
    locked_fields: string[];
  }

  export interface romannumeralmathResponse {
    status: string;
    error: string | null;
    data: RomanNumeralMathData;
    code?: number;
    premium?: PremiumInfo;
  }


  interface RomanNumeralMathData {
      roman1:          null | string;
      roman2:          null | string;
      roman1Value:     number | null;
      roman2Value:     number | null;
      operation:       null | string;
      resultNumber:    number | null;
      resultRoman:     null | string;
      equationNumeric: null | string;
      equationRoman:   null | string;
  }

  export default class romannumeralmathWrapper {
    constructor(options: romannumeralmathOptions);

    execute(callback: (error: any, data: romannumeralmathResponse | null) => void): Promise<romannumeralmathResponse>;
    execute(query: Record<string, any>, callback: (error: any, data: romannumeralmathResponse | null) => void): Promise<romannumeralmathResponse>;
    execute(query?: Record<string, any>): Promise<romannumeralmathResponse>;
  }
}
