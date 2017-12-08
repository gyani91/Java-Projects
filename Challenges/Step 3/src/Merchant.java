/**
 * Created by Sumeet Gyanchandani on 4/11/2015.
 */
public class Merchant
{
    public int romanToDecimal(String roman)
    {
        int decimal = 0;
        int lastNumber = 0;
        int length = roman.length();
        roman = roman.toUpperCase();

        if(validateRoman(roman))
        {
            for(int count = length-1; count>=0; count--)
            {
                switch(roman.charAt(count))
                {
                    case 'I':
                        decimal = processDecimal(1, lastNumber, decimal);
                        lastNumber = 1;
                        break;
                    case 'V':
                        decimal = processDecimal(5, lastNumber, decimal);
                        lastNumber = 5;
                        break;
                    case 'X':
                        decimal = processDecimal(10, lastNumber, decimal);
                        lastNumber = 10;
                        break;
                    case 'L':
                        decimal = processDecimal(50, lastNumber, decimal);
                        lastNumber = 50;
                        break;
                    case 'C':
                        decimal = processDecimal(100, lastNumber, decimal);
                        lastNumber = 100;
                        break;
                    case 'D':
                        decimal = processDecimal(500, lastNumber, decimal);
                        lastNumber = 500;
                        break;
                    case 'M':
                        decimal = processDecimal(1000, lastNumber, decimal);
                        lastNumber = 1000;
                        break;
                }

            }
            return decimal;
        }
        return 0;
    }

    private int processDecimal(int value, int lastNumber, int decimal)
    {
        if(lastNumber > value)
        {
            return decimal - value;
        }
        else
        {
            return decimal + value;
        }
    }
    private boolean validateRoman(String roman)
    {

        return roman.matches("^M{0,3}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$");

    }

}
