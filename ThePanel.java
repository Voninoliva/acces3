package serveur;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Image;
public class ThePanel extends JPanel{
    Image image;
    public ThePanel(){}
    public ThePanel(Image image) {
        this.image = image;
    }
    public Image getImage() {
        return image;
    }
    public void setImage(Image image) {
        this.image = image;
    }
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(this.image,0,0, this.getWidth(), this.getHeight(),this);
    }
}
