declare module '@apiverve/romannumeralmath' {
  export interface romannumeralmathOptions {
    api_key: string;
    secure?: boolean;
  }

  export interface romannumeralmathResponse {
    status: string;
    error: string | null;
    data: RomanNumeralMathData;
    code?: number;
  }


  interface RomanNumeralMathData {
      roman1:          string;
      roman2:          string;
      roman1Value:     number;
      roman2Value:     number;
      operation:       string;
      resultNumber:    number;
      resultRoman:     string;
      equationNumeric: string;
      equationRoman:   string;
  }

  export default class romannumeralmathWrapper {
    constructor(options: romannumeralmathOptions);

    execute(callback: (error: any, data: romannumeralmathResponse | null) => void): Promise<romannumeralmathResponse>;
    execute(query: Record<string, any>, callback: (error: any, data: romannumeralmathResponse | null) => void): Promise<romannumeralmathResponse>;
    execute(query?: Record<string, any>): Promise<romannumeralmathResponse>;
  }
}
