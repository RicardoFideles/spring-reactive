package br.com.rf.springreactive.event;

import java.util.Date;

import br.com.rf.springreactive.model.Car;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarEvents {
	private Car model;
	private Date when;

}
