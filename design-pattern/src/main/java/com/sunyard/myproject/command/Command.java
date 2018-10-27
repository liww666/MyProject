package com.sunyard.myproject.command;

/**
 * Created by Administrator on 2018/9/23.
 */
public abstract class Command {
    protected RequirementGroup rg=new RequirementGroup();
    protected PageGroup pg=new PageGroup();
    protected CodeGroup cg=new CodeGroup();
    protected abstract void execute();
}
