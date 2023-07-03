public class TestMethods {

        public static void main(String[] a) {
                Fraction[] test1 = { new Fraction(1, 3), new Fraction(2, 7), new Fraction(3, 5),
                                new Fraction(11, 19), new Fraction(3, 5), new Fraction(2, 7), new Fraction(1, 3) };
                Fraction[] test2 = { new Fraction(1, 11), new Fraction(2, 11), new Fraction(1, 5), new Fraction(1, 3),
                                new Fraction(1) };
                Fraction[] test3 = { new Fraction(-1, 11), new Fraction(2, 11), new Fraction(-1, 5), new Fraction(1, 3),
                                new Fraction(-1) };
                Fraction[] test4 = { new Fraction(1, 11), new Fraction(-2, 11), new Fraction(-1, 5), new Fraction(1, 3),
                                new Fraction(1) };
                Fraction[] test5 = { new Fraction(1, 11), new Fraction(2, 11), new Fraction(-1, 5), new Fraction(1, 3),
                                new Fraction(1) };
                Fraction[] test6 = { new Fraction(-1, 11), new Fraction(-2, 11), new Fraction(-1, 5),
                                new Fraction(-1, 3),
                                new Fraction(-1) };
                Fraction[] test7 = { new Fraction(1, 3), new Fraction(2, 7), new Fraction(3, 5),
                                new Fraction(), new Fraction(11, 19), new Fraction(), new Fraction(2, 7),
                                new Fraction(1, 3) };
                Fraction[] test8 = { new Fraction(), new Fraction(2, 7), new Fraction(3, 5), new Fraction(),
                                new Fraction(),
                                new Fraction(11, 19), new Fraction(3, 1), new Fraction(2, 7), new Fraction(1, 3),
                                new Fraction() };

                System.out.println("countNegatives - SOLL: 3 / 1 - IST:  " +
                                Blatt2.countNegatives(test3).toString());
                System.out.println("countNegatives - SOLL: 2 / 1 - IST:  " +
                                Blatt2.countNegatives(test4).toString());

                System.out.println("sumUpNegatives - SOLL: -71 / 55 - IST:  " +
                                Blatt2.sumUpNegatives(test3).toString());
                System.out.println("sumUpNegatives - SOLL: -21 / 55 - IST:  " +
                                Blatt2.sumUpNegatives(test4).toString());

                System.out.println("maximum - SOLL: 3 / 5 - IST:  " + Blatt2.maximum(
                                test1).toString());
                System.out.println("maximum - SOLL: 1 / 1 - IST:  " + Blatt2.maximum(
                                test4).toString());

                System.out.println("countMaximum - SOLL: 2 / 1 - IST:  " +
                                Blatt2.countMaximum(test1).toString());
                System.out.println("countMaximum - SOLL: 1 / 1 - IST:  " +
                                Blatt2.countMaximum(test5).toString());

                System.out.println("isSorted - SOLL: true - IST:  " + Blatt2.isSorted(
                                test2));
                System.out.println("isSorted - SOLL: false - IST:  " +
                                Blatt2.isSorted(test4));

                System.out.println("increaseArray - SOLL: " + Blatt2.toString(new Fraction[] { new Fraction(12, 11),
                                new Fraction(13, 11), new Fraction(6, 5), new Fraction(4, 3), new Fraction(2) }));
                System.out.println("increaseArray - IST:  " + Blatt2.toString(
                                Blatt2.increaseArray(test2, new Fraction(1))));

                System.out.println("doubleIfContainsPositive - SOLL: " +
                                Blatt2.toString(new Fraction[] { new Fraction(24, 11), new Fraction(26, 11),
                                                new Fraction(12, 5), new Fraction(8, 3), new Fraction(4) }));
                System.out.println("doubleIfContainsPositive - IST:  " +
                                Blatt2.toString(Blatt2.doubleIfContainsPositive(test2)));
                System.out.println("doubleIfContainsPositive - SOLL: " +
                                Blatt2.toString(new Fraction[] { new Fraction(-1, 11), new Fraction(-2, 11),
                                                new Fraction(-1, 5), new Fraction(-1, 3), new Fraction(-1) }));
                System.out.println("doubleIfContainsPositive - IST:  " +
                                Blatt2.toString(Blatt2.doubleIfContainsPositive(test6)));

                System.out.println("selectNegatives - SOLL: " + Blatt2.toString(
                                new Fraction[] { new Fraction(-1, 11), new Fraction(-1, 5), new Fraction(-1) }));
                System.out.println("selectNegatives - IST:  " + Blatt2.toString(
                                Blatt2.selectNegatives(test3)));

                System.out.println("countSequences - SOLL: 3 / 1 - IST: " +
                                Blatt2.countSequences(test7).toString());
                System.out.println("countSequences - SOLL: 2/ 1 - IST: " +
                                Blatt2.countSequences(test8).toString());

        }
}
