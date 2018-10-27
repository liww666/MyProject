package com.sunyard.myproject.command;

/**
 * Created by Administrator on 2018/9/23.
 */
public class ChangeCodeCommand extends Command {
    @Override
    protected void execute() {
        super.cg.change();
    }
}
