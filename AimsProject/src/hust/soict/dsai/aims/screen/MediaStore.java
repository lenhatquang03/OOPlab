package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.media.Disc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;

import javax.swing.*;
import java.awt.*;

public class MediaStore extends JPanel {
    private Media media;

    public MediaStore(Media media) {
        this.media = media;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel title = new JLabel(media.getTitle());
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 20));
        title.setAlignmentX(CENTER_ALIGNMENT);

        JLabel cost = new JLabel("" + media.getCost() + "$");
        JPanel container = new JPanel();
        container.setLayout(new FlowLayout(FlowLayout.CENTER));

        JButton btnAddCart = new JButton(("Add to cart"));
        container.add(btnAddCart);

        JButton btnPlay = new JButton("Play");

        if (media instanceof Playable) {
            container.add(btnPlay);
        }

        this.add(Box.createVerticalGlue());
        this.add(title);
        this.add(cost);
        this.add(Box.createVerticalGlue());
        this.add(container);

        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }

    public static void main(String[] args) {
        Disc d1 = new Disc();
        MediaStore mdStore = new MediaStore(d1);
    }
}
