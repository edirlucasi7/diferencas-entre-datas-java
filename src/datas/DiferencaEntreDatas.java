package datas;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class DiferencaEntreDatas {

	public static void main(String[] args) {	
		
		try {
			diferencasEntreDataAteJava7();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		
		diferencasEntreDataAteJava8();
		
		diferencasEntreDataAteJava8ComLocalDateTime();
		
		diferencasEntreDataAteJava8ComChronoUnit();
	
		
	}
	
	//Date
	public static void diferencasEntreDataAteJava7() throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date primeiroDt = sdf.parse("17/05/2020");
		Date segundoDt = sdf.parse("18/09/2020");
		
		long difEmMil = Math.abs(segundoDt.getTime() - primeiroDt.getTime());
		
		long dif = TimeUnit.DAYS.convert(difEmMil, TimeUnit.MILLISECONDS);
		
		// forma matematica
		int difDias = (int) (difEmMil / (1000 * 60 * 60 * 24));
		
		System.out.println(dif + " dias");
		System.out.println(difDias + " dias");
	
	}
	
	//LocalDate
	public static void diferencasEntreDataAteJava8() {
				
		LocalDate data1 = LocalDate.of(2020, Month.FEBRUARY, 17);
		LocalDate data2 = LocalDate.of(2018, Month.MAY, 18);
		
		// é necessário pegar todas as partes interesssadas
		Period periodo = Period.between(data1, data2);
		int dias = periodo.getDays();
		int absDias = Math.abs(dias);
		int meses = periodo.getMonths();
		int absMeses = Math.abs(meses);
		int anos = periodo.getYears();
		int absAnos = Math.abs(anos);
		
		System.out.println("Dias: " + absDias);
		System.out.println("Meses: " + absMeses);
		System.out.println("Anos: " + absAnos);
		
	}
	
	//LocalDateTime
	public static void diferencasEntreDataAteJava8ComLocalDateTime() {
		LocalDateTime data1 = LocalDateTime.of(2019, 1, 14, 7, 30);
		LocalDateTime data2 = LocalDateTime.of(2019, 1, 16, 18, 30);
		
		Duration duracao = Duration.between(data1, data2);
		long difHoras = duracao.toHours();
		long difDias = duracao.toDays();
		
		System.out.println(difHoras + " horas");
		System.out.println(difDias + " dias");

	}
	
	public static void diferencasEntreDataAteJava8ComChronoUnit() {
		LocalDateTime data1 = LocalDateTime.of(2019, 1, 14, 7, 30);
		LocalDateTime data2 = LocalDateTime.of(2019, 1, 16, 18, 30);
		
		long difHoras = ChronoUnit.HOURS.between(data1, data2);
		long difDias = ChronoUnit.DAYS.between(data1, data2);
		
		System.out.println(difHoras + " horas");
		System.out.println(difDias + " dias");
	}
	
}
