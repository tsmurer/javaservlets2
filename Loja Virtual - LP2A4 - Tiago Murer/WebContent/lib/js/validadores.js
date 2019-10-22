function validadores(cpf, email, form, validadorCPF, validadorEmail){
	validacaoEmail(email, form, validadorEmail)
	validacaoCPF(cpf, form, validadorCPF)
}

function validacaoCPF(cpf, form, validadorCPF){
	
	regex = /\d{3}\.\d{3}\.\d{3}-\d{2}/
	result = regex.test(cpf)
		
	if (cpf == '000.000.000-00'
		|| cpf == '111.111.111-11'
		|| cpf == '222.222.222-22'
		|| cpf == '333.333.333-33'
		|| cpf == '444.444.444-44'
		|| cpf == '555.555.555-55'
		|| cpf == '666.666.666-66'
		|| cpf == '777.777.777-77'
		|| cpf == '888.888.888-88'
		|| cpf == '999.999.999-99'
		|| result == false){
		alert("CPF Inválido");
		validadorCPF.value = "false";
	} else{
		validadorCPF.value = "true";
	}
	form.submit();
}

function validacaoEmail(email, form, validadorEmail){
	
	regex = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/
	result = regex.test(email)
	
	if (result == false){
		alert("Email Inválido");
		validadorEmail.value = "false";
	} else{
		validadorEmail.value = "true";
	}
}