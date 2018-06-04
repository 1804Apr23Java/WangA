package com.revature.beans;
import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="GREETING")
public class Greeting implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = -4809601905037686597L;
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="greetingSequence")
	@SequenceGenerator(allocationSize=1,name="greetingSequence",sequenceName="SQ_GREETING_PK")
	@Column(name="GREETING_ID")
	private int id;
	
	@Column(name="CONTENT")
    private String content;

    public Greeting(int id, String content) {
        this.id = id;
        this.content = content;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
		this.id = id;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getContent() {
        return content;
    }
}
