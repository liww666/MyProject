package com.sunyard.myproject.command;

/**
 * Created by Administrator on 2018/9/23.
 */
public class DeletePageCommand extends Command {
    @Override
    protected void execute() {
        super.pg.find();
        super.pg.delete();
        super.pg.plan();
    }
}
