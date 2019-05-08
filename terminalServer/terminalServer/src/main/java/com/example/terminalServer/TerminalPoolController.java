package com.example.terminalServer;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/terminal")
public class TerminalPoolController {

	@Autowired
	private List<Terminal> terminalPool;

//	public static final List<Terminal> terminalPool = new Terminal().createTerminalPool();
	private int availableTerminal = 0;

	@RequestMapping(value = "/", method = RequestMethod.GET, produces = { "application/json" })
	public Terminal fetchTerminalInfo() {
		Terminal t = null;
//		 int availableTerminal = 0;

//		if(runCount==1 || runCount==2) {

		if (availableTerminal == 5) {
			System.out.println("block5");
			try {
				Thread.sleep(2000);
				if (availableTerminal == 5) {
					t = new Terminal("503 Service Unavailable");
					System.out.println(t);
					return t;
				}

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		for (int i = 0; i < terminalPool.size(); i++) {
			t = terminalPool.get(i);
			System.out.println(!t.isLocked());

			System.out.println(i + "(8888)(");
			if (!t.isLocked()) {
				System.out.println(i + "()(");
				t.setLocked(true);
				t.setTimestamp(new Date());
				int seqId = t.getSequenceNo();
				if (seqId == 7) {
					t.setSequenceNo(0);
				} else {
					t.setSequenceNo(seqId + 1);
				}
				availableTerminal = availableTerminal + 1;
				break;

			}

		}

		for (Terminal ter : terminalPool) {
			System.out.println(ter.toString());
		}
		System.out.println(availableTerminal);
		return t;

	}

	@RequestMapping(value = "/{terminalId}", method = RequestMethod.PUT, produces = { "application/json" })
	public Terminal updateTerminalLock(@PathVariable("terminalId") String terminalId) {
		System.out.println("update");
		Terminal t = null;
		for (int i = 0; i < terminalPool.size(); i++) {

			t = terminalPool.get(i);
			int id = t.getTerminalId();
			int terId = Integer.parseInt(terminalId);
			if (id == terId) {
				if (availableTerminal > 0 && t.isLocked()==true) {  
					System.out.println("matched");
					t.setLocked(false);
					availableTerminal = availableTerminal - 1;  
					System.out.println(availableTerminal);
				}
				break;
			}

		}

		return t;
	}

//	@RequestMapping(value = "/{terminalId}", method = RequestMethod.GET, produces = { "application/json" })
//	public String updateTal(@PathVariable("terminalId") String terminalId) {return "e";}

}
