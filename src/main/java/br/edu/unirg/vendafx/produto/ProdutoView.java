/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.unirg.vendafx.produto;

import com.airhacks.afterburner.views.FXMLView;

/**
 *
 * @author Rogério M. de Queiroz <rogerio.mq@gmail.com>
 */
public class ProdutoView extends FXMLView {
    
    public ProdutoPresenter getRealPresenter() {
        return (ProdutoPresenter) super.getPresenter();
    }
    
}
