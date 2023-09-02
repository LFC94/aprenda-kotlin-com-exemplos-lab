enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

data class Usuario(val nome:String, val cpf:String)

data class ConteudoEducacional(val nome: String, val duracao: Int = 60)

data class Formacao(val nome: String, val nivel: Nivel, var conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()
    
    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
    }
   
  
    override fun toString() = "$nome $nivel conteudos$conteudos inscritos$inscritos"
    
}

fun main() {
    var conteudoEducacional = mutableListOf<ConteudoEducacional>()
    conteudoEducacional.add(ConteudoEducacional("Java", 100))
    conteudoEducacional.add(ConteudoEducacional("PHP", 120))
    println(conteudoEducacional)
    
    var formacao = Formacao("Back", Nivel.INTERMEDIARIO, conteudoEducacional)
    println(formacao)
    
    formacao.matricular(Usuario(nome = "Lucas", cpf="41562"))
    formacao.matricular(Usuario(nome = "Jose", cpf="5655"))
    println(formacao)
}