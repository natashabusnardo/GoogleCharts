package googleCharts;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class GerarHTML {
	
	public static void gerarHtml(int[] vetor) throws IOException {
		
		String html2 = "<html>\r\n" + 
				"<head>\r\n" + 
				"  <script type=\"text/javascript\" src=\"https://www.gstatic.com/charts/loader.js\"></script>\r\n" + 
				"    <script type=\"text/javascript\">\r\n" + 
				"      google.charts.load('current', {'packages':['line']});\r\n" + 
				"      google.charts.setOnLoadCallback(drawChart);\r\n" + 
				"\r\n" + 
				"    function drawChart() {\r\n" + 
				"\r\n" + 
				"      var data = new google.visualization.DataTable();\r\n" + 
				"      data.addColumn('number', 'Dia');\r\n" + 
				"      data.addColumn('number', 'Número de vendas por dia');\r\n" + 

				"\r\n" + 
				"      data.addRows([\r\n" + 	retornaDados2(vetor) +		"      ]);\r\n" + 
				"\r\n" + 
				"      var options = {\r\n" + 
				"        chart: {\r\n" + 
				"          title: 'Número de vendas por tempo de lançamento',\r\n" + 
				"          subtitle: 'Por dia de lançamento'\r\n" + 
				"        },\r\n" + 
				"        width: 900,\r\n" + 
				"        height: 500,\r\n" + 
				"        axes: {\r\n" + 
				"          x: {\r\n" + 
				"            0: {side: 'top'}\r\n" + 
				"          }\r\n" + 
				"        }\r\n" + 
				"      };\r\n" + 
				"\r\n" + 
				"      var chart = new google.charts.Line(document.getElementById('line_top_x'));\r\n" + 
				"\r\n" + 
				"      chart.draw(data, google.charts.Line.convertOptions(options));\r\n" + 
				"    }\r\n" + 
				"  </script>\r\n" + 
				"</head>\r\n" + 
				"<body>\r\n" + 
				"  <div id=\"line_top_x\"></div>\r\n" + 
				"</body>\r\n" + 
				"</html>\r\n" + 
				"\r\n" + 
				"";
		
		
		FileWriter arq = new FileWriter("..//grafico.html");
	    PrintWriter gravarArq = new PrintWriter(arq);
	 
	    gravarArq.printf(html2);
	    arq.close();
	}
	
	
	private static String retornaDados2(int[] vetor) {
		String dados = "";
		for (int i = 0; i<vetor.length; i++) {
			dados += "[" + String.valueOf(i+1) + ", " + String.valueOf(vetor[i]) +"],\r\n";
		}
		return dados;
	}
}
