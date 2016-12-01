/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.unirg.vendafx.produto.produtoedit;

import com.airhacks.afterburner.views.FXMLView;

/**
 *
 * @author Rogério M. de Queiroz <rogerio.mq@gmail.com>
 */
public class ProdutoEditView extends FXMLView {
    
    public ProdutoEditPresenter getRealPresenter() {
        return (ProdutoEditPresenter) super.getPresenter();
    }
    
}
