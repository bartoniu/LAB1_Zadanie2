import java.util.Scanner;

class Pesel {
    String number;

    public Pesel(String number)
    {
        this.number = number;
    }

    void isGenderValid()
    {
        int num = Character.getNumericValue(number.charAt(9));
        System.out.println((num % 2 == 1) ? "Plec: Mezczyna" : "Plec: Kobieta"); // NP - M / P - k
    }

    void isBirthDateValid()
    {
        int num = Character.getNumericValue(number.charAt(2));
        switch(num)
            {
                case 0:
                    System.out.println ("Data urodzenia: 19"+number.charAt(0)+number.charAt(1)+"-"+number.charAt(2)+number.charAt(3)+"-"+number.charAt(4)+number.charAt(5));
                    break;
                case 1:
                    System.out.println ("Data urodzenia: 19"+number.charAt(0)+number.charAt(1)+"-"+number.charAt(2)+number.charAt(3)+"-"+number.charAt(4)+number.charAt(5));
                    break;
                case 2:
                    System.out.println ("Data urodzenia: 20"+number.charAt(0)+number.charAt(1)+"-0"+number.charAt(3)+"-"+number.charAt(4)+number.charAt(5));
                    break;
                case 3:
                    System.out.println ("Data urodzenia: 20"+number.charAt(0)+number.charAt(1)+"-1"+number.charAt(3)+"-"+number.charAt(4)+number.charAt(5));
                    break;
                case 4:
                    System.out.println ("Data urodzenia: 21"+number.charAt(0)+number.charAt(1)+"-0"+number.charAt(3)+"-"+number.charAt(4)+number.charAt(5));
                    break;
                case 5:
                    System.out.println ("Data urodzenia: 21"+number.charAt(0)+number.charAt(1)+"-1"+number.charAt(3)+"-"+number.charAt(4)+number.charAt(5));
                    break;
                case 6:
                    System.out.println ("Data urodzenia: 22"+number.charAt(0)+number.charAt(1)+"-0"+number.charAt(3)+"-"+number.charAt(4)+number.charAt(5));
                    break;
                case 7:
                    System.out.println ("Data urodzenia: 22"+number.charAt(0)+number.charAt(1)+"-1"+number.charAt(3)+"-"+number.charAt(4)+number.charAt(5));
                    break;
                case 8:
                    System.out.println ("Data urodzenia: 18"+number.charAt(0)+number.charAt(1)+"-0"+number.charAt(3)+"-"+number.charAt(4)+number.charAt(5));
                    break;
                case 9:
                    System.out.println ("Data urodzenia: 18"+number.charAt(0)+number.charAt(1)+"-1"+number.charAt(3)+"-"+number.charAt(4)+number.charAt(5));
                    break;
                default:
                    System.out.println("");
                    break;
            }
    }

}

class Zadanie2
{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String testedvalue = "";
        do
            {
                System.out.println("Wprowadz numer PESEL: ");
                testedvalue = scan.nextLine();
        }
        while (isNumberValid(testedvalue) != true);

        Pesel pesel = new Pesel(testedvalue);

        pesel.isGenderValid();
        pesel.isBirthDateValid();
    }

    public static boolean isNumberValid(String testedvalue)
    {
        if(testedvalue.length()!=11)
        {
            System.out.println("Wprowadziles bledny pesel!");
            return false;
        }

        int checksum = 9*Character.getNumericValue(testedvalue.charAt(0))+
                7*Character.getNumericValue(testedvalue.charAt(1))+
                3*Character.getNumericValue(testedvalue.charAt(2))+
                1*Character.getNumericValue(testedvalue.charAt(3))+
                9*Character.getNumericValue(testedvalue.charAt(4))+
                7*Character.getNumericValue(testedvalue.charAt(5))+
                3*Character.getNumericValue(testedvalue.charAt(6))+
                1*Character.getNumericValue(testedvalue.charAt(7))+
                9*Character.getNumericValue(testedvalue.charAt(8))+
                7*Character.getNumericValue(testedvalue.charAt(9));

        if(checksum % 10 != Character.getNumericValue(testedvalue.charAt(10)))
        {
            System.out.println("Niezgodnosc sumy kontrolnej, podaj pesel jeszcze raz!");
            return false;
        }

        return true;
    }
}
