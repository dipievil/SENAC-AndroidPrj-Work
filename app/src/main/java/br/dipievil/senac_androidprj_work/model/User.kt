package br.dipievil.senac_androidprj_work.model

data class User (var id: Int = 0,
                var nome: String? = null,
                var address: String? = null,
                var cpf: String? = null,
                var phone: String? = null,
                var email: String? = null
)