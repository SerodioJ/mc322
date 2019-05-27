/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.userinterface;

/**
 *
 * @author yukiharu
 */
public interface IAnimation {
    public void story(String[] falas, String[] personagem);
    public void setWindowName(String name);
    public void setTempo(String v);
    public void setPacientName(String pacName);
    public void setDocName(String docName);
}
