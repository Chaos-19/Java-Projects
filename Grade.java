import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

class InvalidInput extends Exception {
	InvalidInput(String s) {
		super(s);
	}
}

public class GradeCalculater {
	String name;
	String id;
	String[] letterGrade;
	double[] numberGrade;
	double[] gradePoint;
	double GPA;
	String alG;
	double sumGp;
	int sumcredit;
	int privCredit;
	double privGPA;
	double privSumGp;
	int x ;
	int y, m;
	String CumAlg;
	ArrayList<Double> prevGPA = new ArrayList<Double>();
	ArrayList<Integer> prevCredit = new ArrayList<Integer>();
	ArrayList<Double> prevSumGP = new ArrayList<Double>();
	ArrayList<String> ALG = new ArrayList<String>();

	GradeCalculater(){
		
	}

	void ExceptionChecker(double s) throws InvalidInput {
		if (s > 100 || s < 0)
			throw new InvalidInput("You insert negative number or grater than 100");
	}

//Method
	void setLetterGrade(double[] grade, int[] credit, int size) {
		numberGrade = new double[size];
		letterGrade = new String[size];
		for (int i = 0; i < grade.length; i++) {
			if ((grade[i] <= 100) && (grade[i] >= 90)) {
				letterGrade[i] = "A+";
				numberGrade[i] = 4;
			} else if ((grade[i] < 90) && (grade[i] >= 85)) {
				letterGrade[i] = "A";
				numberGrade[i] = 4;
			} else if ((grade[i] < 85) && (grade[i] >= 80)) {
				letterGrade[i] = "A-";
				numberGrade[i] = 3.75;
			} else if ((grade[i] < 80) && (grade[i] >= 75)) {
				letterGrade[i] = "B+";
				numberGrade[i] = 3.5;
			} else if ((grade[i] < 75) && (grade[i] >= 70)) {
				letterGrade[i] = "B";
				numberGrade[i] = 3;
			} else if ((grade[i] < 70) && (grade[i] >= 65)) {
				letterGrade[i] = "B-";
				numberGrade[i] = 2.75;
			} else if ((grade[i] < 65) && (grade[i] >= 60)) {
				letterGrade[i] = "C+";
				numberGrade[i] = 2.5;
			} else if ((grade[i] < 60) && (grade[i] >= 50)) {
				letterGrade[i] = "C";
				numberGrade[i] = 2;
			} else if ((grade[i] < 50) && (grade[i] >= 40)) {
				letterGrade[i] = "D";
				numberGrade[i] = 1;
			} else  {
				letterGrade[i] = "F";
				numberGrade[i] = 0;
			}
		}
	}
//Method
	void setGradePoint(double[] grade, int[] credit, int size) {
		gradePoint = new double[size];
		for (int i = 0; i < grade.length; i++) {
			gradePoint[i] = credit[i] * numberGrade[i];
		}

		for (int i = 0; i < grade.length; i++) {
			sumGp += gradePoint[i];
			sumcredit += credit[i];
		}
	}
	//Method
	void setANG() {
		GPA = sumGp / sumcredit;
		GPA=Math.round(GPA*100.0)/100.0;
	}
	void preSemester() {
		prevGPA.add(GPA);
		prevCredit.add(sumcredit);
		prevSumGP.add(sumGp);
		ALG.add(alG);
	}
	//Method

	void pre() {
		if (x > 0) {
			for (double b : prevGPA) {
				privGPA += b;
			}
			privGPA = privGPA / prevGPA.size();

			for (int c : prevCredit)
				privCredit += c;

			for (double e : prevSumGP) {
				privSumGp += e;
			}

		} else if (x <= 0) {
			privCredit = sumcredit;
			privGPA = GPA;
			privSumGp = sumGp;
			privSumGp = sumGp;
		}
		x++;
	}
	void reset() {
		/*	for (double  c : prevGPA)
				System.out.println(c);
			for (int d : prevCredit)
				System.out.println(d);
			for (double  d : prevSumGP)
				System.out.println(d);
			for (String f: ALG)
				System.out.println(f);	*/
		GPA = 0;
		sumcredit = 0;
		alG = "";
		CumAlg = "";
		sumGp = 0;
		privCredit = 0;
		privGPA = 0;
		privSumGp = 0;
	}
//Method
	void setALG() {
		if (GPA == 4)
			alG = "A";
		else if (GPA<4 & GPA >= 3.75)
			alG = "A-";
		else if (GPA<3.75 & GPA >= 3.5)
			alG = "B+";
		else if (GPA<3.5 & GPA >= 3)
			alG = "B";
		else if (GPA<3 & GPA >= 2.75)
			alG = "B-";
		else if (GPA<2.75 & GPA >= 2.5)
			alG = "C+";
		else if (GPA<2.5 & GPA >= 2)
			alG = "C";
		else if (GPA<2 & GPA >= 1)
			alG = "D";
		else  alG = "F";
	}

	void CumALG() {

		if (privGPA  == 4)
			CumAlg = "A";
		else if (privGPA <4 & privGPA  >= 3.75)
			CumAlg = "A-";
		else if (privGPA <3.75 & privGPA  >= 3.5)
			CumAlg = "B+";
		else if (privGPA <3.5 & privGPA  >= 3)
			CumAlg = "B";
		else if (privGPA <3 & privGPA  >= 2.75)
			CumAlg = "B-";
		else if (privGPA <2.75 & privGPA  >= 2.5)
			CumAlg = "C+";
		else if (privGPA <2.5 & privGPA  >= 2)
			CumAlg = "C";
		else if (privGPA <2 & privGPA >= 1)
			CumAlg = "D";
		else  CumAlg = "F";
	}
	//Method
	void returnAllMethod() throws IOException, InvalidInput {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the number of course you take ");
		int size = s.nextInt();
		double[] grade = new double [size];
		int[] credit = new int[size];
		for (int i = 0; i < grade.length; i++) {
			System.out.println("Enter the course mark");
			grade[i] = s.nextDouble();
			ExceptionChecker(grade[i]);
			System.out.println("enter the credit Hour");
			credit[i] = s.nextInt();
		}
		setLetterGrade(grade, credit, size);
		setGradePoint(grade, credit, size);
		setANG();
		setALG();
		preSemester();
		pre();
		CumALG();
		finalGradeReport(grade, credit, name);

	}
	//Method
	void finalGradeReport(double[] grade, int[] credit, String n) throws IOException {
		System.out.println("\t\t\tDEBRE TABOR UNIVERSITY \n\t\t\t Freshman Faculty\n------------------------------------------------------------------------\n Admission Classification : Regular\t\tMajor : Natural Scince \n\nProgramme : Degree  \t \tAc Year : 2022/2013     Section  : 16\n  Year : 1\t\t Semester : 1\nStudent Name :"
						   + name + "\t  ID :" + id + "  \n \n------------------------------------------------------------------------\n");
		System.out.println("  Credite  Score  Number Letter  Grade\n");

		for (int i = 0; i < grade.length; i++)
			System.out.println("  " + credit[i] + "\t" + grade[i] + "  " + numberGrade[i] + "  " + letterGrade[i] + "  " + gradePoint[i] + "\n");

		if (m <= 1)
			y = 0;
		if (m >= 2)
			y += 1;
		System.out.println("\n\nPrevious total  " + prevCredit.get(y) + "   " + prevSumGP.get(y) + "  " + prevGPA.get(y) + "  " + ALG.get(y) + "\n");

		System.out.println("Semester total  " + sumcredit + "   " + sumGp + "  " + GPA + "  " + alG + "\n");

		System.out.println("Cumulative      " +  privCredit  + "   " + privSumGp + "  " + privGPA + "  " + CumAlg + "\n");
		System.out.println("\tRemark\n\t First Class with grate Distinction \n\t First Class With Distinction \n\t First Class \n\tScond Class \n\t Lower Class \n\tLowest Class  \n\n\t Pass \n\tAcadamic Warnig \n\t Forced withdrawal \n\tAcadamic Dismissal \n\t Complete Acadamic Dismissal ");
		m++;
	}

//Method
	static void getReport(String name) throws FileNotFoundException {
		String fname = name + ".txt";
		Scanner s = new Scanner(new File(fname));
		while (s.hasNext()) {
			System.out.println(s.nextLine());
		}
		s.close();
	}

	public static void main(String[] args) throws IOException {
		Scanner s = new Scanner(System.in);
		System.out.println("\tWellcom to Grade calculator\n ");
		GradeCalculater m = new GradeCalculater();
		int opp;
		do {
			System.out.println("----------#############--------");
			System.out.println("enter 1 to Calculate your Grade ");
			System.out.println("enter 2 to See Grade report ");
			opp = s.nextInt();
			switch (opp) {
			case 1:
				try {
					m.returnAllMethod();
					m.reset();
				} catch (InvalidInput e) {
					System.out.println("You Inser neigther number above 100 or negative ");
				}
				break ;
			case 2:
				try {
					getReport("kal");
				} catch (FileNotFoundException e) {
					System.out.println("You need to Calculate the Grade First");
				}
				break ;
			case 3:
				m.pre();
				break ;
			default :
				System.out.println("Invalid Opption");
			}
		} while (opp != 5);
	}
}