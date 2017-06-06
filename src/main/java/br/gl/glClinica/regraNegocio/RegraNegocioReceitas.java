
package br.gl.glClinica.regraNegocio;

import br.gl.glClinica.entidades.Exames;
import br.gl.glClinica.entidades.Medicamentos;
import br.gl.glClinica.entidades.Receitas;
import br.gl.glClinica.persistencia.InterfaceRepositorioExames;
import br.gl.glClinica.persistencia.InterfaceRepositorioMedicamentos;
import br.gl.glClinica.persistencia.InterfaceRepositorioMedicos;
import br.gl.glClinica.persistencia.InterfaceRepositorioPacientes;
import br.gl.glClinica.persistencia.InterfaceRepositorioReceitas;
import br.gl.glClinica.regraNegocioException.ExceptionReceitasEscrita;
import br.gl.glClinica.regraNegocioException.ExceptionReceitasLeitura;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author manoel
 */
@Service
public class RegraNegocioReceitas implements InterfaceRegraNegocioReceitas {

    @Autowired
    private InterfaceRepositorioReceitas repositorioReceitas;
    @Autowired
    private InterfaceRepositorioMedicos repositorioMedicos;
    @Autowired
    private InterfaceRepositorioPacientes repositorioPacientes;
    @Autowired
    private InterfaceRepositorioExames repositorioExames;
    @Autowired
    private InterfaceRepositorioMedicamentos repositorioMedicamentos;
    
    @Override
    public void gerarReceita(Receitas receita, Long cpfMedico, Long cpfPaciente) throws ExceptionReceitasEscrita {
       
        if(receita == null) {
            throw new ExceptionReceitasEscrita();
        }
        if(cpfMedico == null) {
            throw new ExceptionReceitasEscrita();
        }
        if(cpfMedico<=0) {
            throw new ExceptionReceitasEscrita();
        }
        if(cpfPaciente == null) {
            throw new ExceptionReceitasEscrita();
        }
        if(cpfPaciente <=0) {
            throw new ExceptionReceitasEscrita();
        }
        else {
           receita.setMedico(this.repositorioMedicos.findByCpf(cpfMedico));
           receita.setPaciente(this.repositorioPacientes.findByCpf(cpfPaciente));
        }
        if(receita.getMedico() == null) {
            throw new ExceptionReceitasEscrita();
        }
        if(receita.getPaciente() == null) {
            throw new ExceptionReceitasEscrita();
        }
        if(receita.getDataReceita() == null) {
            throw new ExceptionReceitasEscrita();
        }
        else {
            this.repositorioReceitas.save(receita);
        }
    }

    @Override
    public void atualizarReceita(Receitas receita) throws ExceptionReceitasEscrita {
        
        if(receita == null) {
            throw new ExceptionReceitasEscrita();
        }
        if(receita.getDataReceita() == null) {
            throw new ExceptionReceitasEscrita();
        }
        if(receita.getCodigoReceita()<=0) {
            throw new ExceptionReceitasEscrita();
        }
        if(receita.getMedico() == null) {
            throw new ExceptionReceitasEscrita();
        }
        if(receita.getPaciente() == null) {
            throw new ExceptionReceitasEscrita();
        }
        if(this.repositorioReceitas.exists(receita.getCodigoReceita())==false) {
            throw new ExceptionReceitasEscrita();
        }
        else {
            Receitas novoReceita = this.repositorioReceitas.findByCodigoReceita(receita.getCodigoReceita());
            
               novoReceita.setDataReceita(receita.getDataReceita());
               
                  this.repositorioReceitas.save(novoReceita);
        }
    }

    @Override
    public void deletarReceita(int codigoReceita) throws ExceptionReceitasEscrita {
        
        if(codigoReceita <= 0) {
            throw new ExceptionReceitasEscrita();
        }
        if(this.repositorioReceitas.exists(codigoReceita)==false) {
            throw new ExceptionReceitasEscrita();
        }
        else {
          this.repositorioReceitas.delete(codigoReceita);
        }
    }

    @Override
    public Receitas filtrarReceitaCodigo(int codigoReceita) throws ExceptionReceitasLeitura {
        
       if(codigoReceita <= 0 ) {
           throw new ExceptionReceitasLeitura();
       }
       else {
           return this.repositorioReceitas.findByCodigoReceita(codigoReceita);
       }
    }

    @Override
    public void inserirExameReceita(int codigoReceita, int codigoExame) throws ExceptionReceitasEscrita {
        
        Receitas receita;
        Exames exame;
        
        if(codigoReceita <= 0 ) {
            throw new ExceptionReceitasEscrita();
        }
        if(codigoExame <= 0 ) {
            throw new ExceptionReceitasEscrita();
        }
        else {
            receita = this.repositorioReceitas.findByCodigoReceita(codigoReceita);
            exame = this.repositorioExames.findByCodigoExame(codigoExame);          
        }
        if(receita == null) {
            throw new ExceptionReceitasEscrita();
        }       
        if(exame == null) {
            throw new ExceptionReceitasEscrita();
        }        
        else {
             receita.getExames().add(exame);
             this.repositorioReceitas.save(receita);
        }
    }

    @Override
    public void inserirMedicamentoReceita(int codigoReceita, int codigoMedicamento) throws ExceptionReceitasEscrita {
        
        Receitas receita;
        Medicamentos medicamento;
        
        if(codigoReceita <=0) {
            throw new ExceptionReceitasEscrita();
        }
        if(codigoMedicamento<=0) {
            throw new ExceptionReceitasEscrita();
        }
        else {
           receita = this.repositorioReceitas.findByCodigoReceita(codigoReceita);
           medicamento = this.repositorioMedicamentos.findByCodigoMedicamento(codigoMedicamento);
        }        
        if(receita == null) {
            throw new ExceptionReceitasEscrita();
        }        
        if(medicamento == null) {
            throw new ExceptionReceitasEscrita();
        }
        else {
            receita.getMedicamentos().add(medicamento);                 
            this.repositorioReceitas.save(receita);
        }        
    }

    public InterfaceRepositorioReceitas getRepositorioReceitas() {
        return repositorioReceitas;
    }

    public void setRepositorioReceitas(InterfaceRepositorioReceitas repositorioReceitas) {
        this.repositorioReceitas = repositorioReceitas;
    }

    public InterfaceRepositorioMedicos getRepositorioMedicos() {
        return repositorioMedicos;
    }

    public void setRepositorioMedicos(InterfaceRepositorioMedicos repositorioMedicos) {
        this.repositorioMedicos = repositorioMedicos;
    }

    public InterfaceRepositorioPacientes getRepositorioPacientes() {
        return repositorioPacientes;
    }

    public void setRepositorioPacientes(InterfaceRepositorioPacientes repositorioPacientes) {
        this.repositorioPacientes = repositorioPacientes;
    }

    public InterfaceRepositorioExames getRepositorioExames() {
        return repositorioExames;
    }

    public void setRepositorioExames(InterfaceRepositorioExames repositorioExames) {
        this.repositorioExames = repositorioExames;
    }

    public InterfaceRepositorioMedicamentos getRepositorioMedicamentos() {
        return repositorioMedicamentos;
    }

    public void setRepositorioMedicamentos(InterfaceRepositorioMedicamentos repositorioMedicamentos) {
        this.repositorioMedicamentos = repositorioMedicamentos;
    }
    
}
