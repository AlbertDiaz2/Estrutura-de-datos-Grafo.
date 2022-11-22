// CLiente

public class Cliente
{
	public static void main(String[] args)
	{
		//GrafoNoDirigido n = GrafoNoDirigido();
		Digrafo d = new Digrafo();
		//n.cargarGrafo(args[0]);
		System.out.println("xxxxxxxxxxxxxxxxxxxx");
		d.cargarGrafo(args[0]);
		//d.adyacentes("6");
		//d.mostrarGrafo();
		System.out.println("JA" + d.adyacentes("10")); 



	}

}