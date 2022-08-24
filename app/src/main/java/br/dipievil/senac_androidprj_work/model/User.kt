package br.dipievil.senac_androidprj_work.model

data class User (var id: String? = null,
                 var name: String? = null,
                 var address: String? = null,
                 var cpf: String? = null,
                 var phone: String? = null,
                 var email: String? = null
){
    fun toMap(): Map<String, Any?> {
        return mapOf(
            "id" to id,
            "name" to name,
            "address" to address,
            "cpf" to cpf,
            "phone" to phone,
            "email" to email
        )
    }
}