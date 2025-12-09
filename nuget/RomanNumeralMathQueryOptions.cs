using System;
using System.Collections.Generic;
using System.Text;
using Newtonsoft.Json;

namespace APIVerve.API.RomanNumeralMath
{
    /// <summary>
    /// Query options for the Roman Numeral Math API
    /// </summary>
    public class RomanNumeralMathQueryOptions
    {
        /// <summary>
        /// The first Roman numeral
        /// Example: XIV
        /// </summary>
        [JsonProperty("roman1")]
        public string Roman1 { get; set; }

        /// <summary>
        /// The second Roman numeral
        /// Example: VI
        /// </summary>
        [JsonProperty("roman2")]
        public string Roman2 { get; set; }

        /// <summary>
        /// Operation to perform: add, subtract, multiply, or divide (default: add)
        /// Example: add
        /// </summary>
        [JsonProperty("operation")]
        public string Operation { get; set; }
    }
}
