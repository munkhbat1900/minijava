class Factorial{
	public static void main(String[] a){
		System.out.println(new Fac().ComputeFac(10));
	}
}

class Fac {
	public int ComputeFac(int num){
		int num_aux ;
		boolean a;
		boolean b;
		boolean c;
		
		c = a && b;
		if (num < 1)
			num_aux = 1 ;
		else 
			num_aux = num * (this.ComputeFac(num-1)) ;
		return num_aux ;
	}
}

class Fact extends Fac {
	public int subTypeCheck(int num){
		int num_aux ;
		Fac f1;
		Fact ft;
		f1 = ft;
		num_aux = ft.ComputeFac1(4);
		return num_aux ;
	}
}