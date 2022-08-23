package br.dipievil.senac_androidprj_work.model

data class Book(var id: String? = null,
                var title: String? = null,
                var subtitle: String? = null,
                var volume: Int = 0,
                var edition: Int = 0,
                var year: String? = null,
                var publisher: String? = null,
                var area: String? = null,
                var genre : String? = null,
                var subgenre: String? = null,
                var isbn: String? = null,
                var cdd: String? = null,
                var aquisition: String? = null,
                var status: String? = null,
                var author: String? = null,
                var pages: Int = 0)