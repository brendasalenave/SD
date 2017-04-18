public class Mensagem implements java.io.Serializable {
	/** Tipos de mensagens POP, PUSH, RET_POP */
	public String tipo;
	public short numero;
	
	public Mensagem(String tipo, short numero) {
		this.tipo = tipo;
		this.numero = numero;
	}
	
	public Mensagem() {
		this.tipo = "";
		this.numero = (short)0;
	}
	
	public void setTipo(String t) {
		tipo = t;
	}
	
	public String getTipo() {
		return tipo;
	}
	
	public void setNumero(short n) {
		numero = n;
	}
	
	public short getNumero() { 
		return numero;
	}
}