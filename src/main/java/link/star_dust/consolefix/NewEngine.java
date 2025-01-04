package link.star_dust.consolefix;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

public class NewEngine implements EngineInterface {
    private CSF csf;
    private int msgHidden = 0;

    public NewEngine(CSF csf) {
        this.csf = csf;
    }

    @Override
    public int getHiddenMessagesCount() {
        return this.msgHidden;
    }

    @Override
    public void addHiddenMsg() {
        ++this.msgHidden;
    }

    @Override
    public void hideConsoleMessages() {
        Logger rootLogger = (Logger) LogManager.getRootLogger();
        rootLogger.addFilter(new LogFilter(this.csf));
    }
}
