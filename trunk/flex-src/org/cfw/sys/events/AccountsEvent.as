package org.cfw.sys.events
{
	import flash.events.Event;
	
	import mx.modules.ModuleLoader;
	
	public class AccountsEvent extends Event
	{
		public static const QUERYALLACCOUNTS:String="queryAllAccounts";
		
		public var url:String;
		public var moduleLoader:ModuleLoader;
		public var loginAccount:String;
		public function AccountsEvent(type:String, 
			bubbles:Boolean=true, cancelable:Boolean=false)
		{
			super(type, bubbles, cancelable);
		}

	}
}