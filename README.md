# sum-distances
A basic webservice that is able to sum two distances, in yards or meters and return the result in either unit.

Usage = /distance/{distance1}/{distance2}?isYardsUnit1={boolean1}&isYardsUnit2={boolean2}&isYardsResult={boolean3}
Replace {distance1} and {distance2} with numbers that specify the distances to sum. 
Replace {boolean1}, {boolean2} and {boolean3} with either true or false depending on whether the unit should be in yards (true) or meters (false). Not specifying the parameters defaults to meters.

Example usage: http://localhost:8080/distance/10/5?isYardsUnit1=true&isYardsUnit2=true&isYardsResult=true

Navigate to doc/approach.txt for more info.
