/*
* This code has been generated by the Rebel: a code generator for modern Java.
*
* Drop us a line or two at feedback@archetypesoftware.com: we would love to hear from you!
*/
package PackageVendite;

import java.util.*;
import java.time.*;



// ----------- << imports@AAAAAAF3YzvYmgCzz/w= >>
// ----------- >>

// ----------- << class.annotations@AAAAAAF3YzvYmgCzz/w= >>
// ----------- >>
public class Vendite {
    // ----------- << attribute.annotations@AAAAAAF3Y345IQIGt2g= >>
    // ----------- >>
    private void sales;

    // ----------- << attribute.annotations@AAAAAAF3Y35LfgIMU/U= >>
    // ----------- >>
    private Prevendite presales;

    // ----------- << attribute.annotations@AAAAAAF3cj210LMeSEk= >>
    // ----------- >>
    private Set<Prevendite>  = new HashSet<>();

    // ----------- << attribute.annotations@AAAAAAF3cj//yrSH+4A= >>
    // ----------- >>
    private VenditePubbliche ;

    private void getSales() {
        return sales;
    }

    private Prevendite getPresales() {
        return presales;
    }

    public Set<Prevendite> get() {
        return ;
    }

    public VenditePubbliche get() {
        return ;
    }

    private void setSales(void sales) {
        this.sales = sales;
    }

    private void setPresales(Prevendite presales) {
        this.presales = presales;
    }

    public void set(VenditePubbliche ) {
        this. = ;
    }

    public void link(Prevendite _) {
        if (_ != null) {
            get().add(_);
        }
    }

    public void link(VenditePubbliche _) {
        set(_);
    }

    public void unlink(Prevendite _) {
        if (_ != null) {
            get().remove(_);
        }
    }

    public void unlink(Iterator<Prevendite> it) {
        it.remove();
    }

    public void unlink() {
        set(null);
    }

    // ----------- << method.annotations@AAAAAAF3Y7ig53jOpXg= >>
    // ----------- >>
    public Vendite() {
    // ----------- << method.body@AAAAAAF3Y7ig53jOpXg= >>
    // ----------- >>
    }
// ----------- << class.extras@AAAAAAF3YzvYmgCzz/w= >>
// ----------- >>
}