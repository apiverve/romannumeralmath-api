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
        /// </summary>
        [JsonProperty("roman1")]
        public string Roman1 { get; set; }

        /// <summary>
        /// The second Roman numeral
        /// </summary>
        [JsonProperty("roman2")]
        public string Roman2 { get; set; }

        /// <summary>
        /// Operation to perform
        /// </summary>
        [JsonProperty("operation")]
        public string Operation { get; set; }
    }
}
