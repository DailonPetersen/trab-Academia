package com.gym;

import com.model.*;

import java.util.Calendar;
import java.text.SimpleDateFormat;

import com.controller.*;
import com.dao.*;

public class test {

	public static void main(String[] args) {

		Treino treino1 = new Treino();
		TreinoBean ab = new TreinoBean();
		
		Aluno aluno = new Aluno();
		AlunoBean ab2 = new AlunoBean();
		
		aluno = ab2.buscarAluno();
		
		treino1.setAluno(aluno);
		
		treino1.setHorario("manha");
		
		Calendar c = Calendar.getInstance();
		int ano = c.get(Calendar.YEAR);
		int mes = c.get(Calendar.MONTH);
		int dia = c.get(Calendar.DATE);
		c.set(ano, mes, dia);
		
		treino1.setData(c);
		
		ab.salvar(treino1);
		
	}

}
