package br.com.arearestrita.model;

import br.com.arearestrita.model.anotations.ActivePattern;
import br.com.arearestrita.model.interfaces.OnSave;
import br.com.arearestrita.model.interfaces.OnUpdate;
import com.google.gson.annotations.Expose;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * Description the class br.com.arearestrita.core.EntidadeDominio - Classe de objeto real
 * br.com.arearestrita.core.EntidadeDominio.
 *
 * @author Daniela Xavier Conceição - sistemas@fozadvogados.com.br
 * @version  $Revision: 1
 * @since Build 0.1 02/12/019
 */

@MappedSuperclass
@Data
public class DomainEntity implements IEntity, Serializable {

    private static final long serialVersionUID = -5377726703339445533L;

    @Expose
    @Column(name = "INCLUIDO_EM")
    @NotNull(message = "Item data de inclusão inválido", groups = {OnSave.class})
    @Temporal(TemporalType.TIMESTAMP)
    private Date includedIn;

    @Expose
    @Column(name = "ALTERADO_EM")
    @NotNull(message = "Item data de alterado inválido", groups = {OnUpdate.class})
    @Temporal(TemporalType.TIMESTAMP)
    private Date changedIn;

    @Expose
    @NotEmpty(message = "Item incluido por inválido", groups = {OnSave.class})
    @Column(name = "INCLUIDO_POR")
    private String includedBy;

    @Expose
    @Column(name = "ALTERADO_POR")
    @NotEmpty(message = "Item alterado por inválido", groups = {OnUpdate.class})
    private String changedBy;

    @Expose
    @NotNull(message = "Item ativo inválido", groups = {OnSave.class})
    @NotEmpty(message = "Item ativo não pode estar em branco", groups = {OnSave.class})
    @ActivePattern(message = "Item ativo deve ser Sim(s) ou Não(n)", groups = {OnSave.class, OnUpdate.class})
    @Column(name = "ATIVO")
    private String active;

    @Transient
    private String owner;

    @Transient
    private String token;
}