package org.cfw.common
{
	public class WebUserVO
	{
		private var _account:String;
		private var _name:String;
		private var _loginDate:Date;
		private var _roleId:int;
		private var _ip:String;
		private var _permission:PermissionVO;
		
		
		public function get account():String
		{
			return _account;
		}

		public function set account(value:String):void
		{
			_account = value;
		}

		public function get name():String
		{
			return _name;
		}

		public function set name(value:String):void
		{
			_name = value;
		}

		public function get loginDate():Date
		{
			return _loginDate;
		}

		public function set loginDate(value:Date):void
		{
			_loginDate = value;
		}

		public function get roleId():int
		{
			return _roleId;
		}

		public function set roleId(value:int):void
		{
			_roleId = value;
		}

		public function get ip():String
		{
			return _ip;
		}

		public function set ip(value:String):void
		{
			_ip = value;
		}

		public function get permission():PermissionVO
		{
			return _permission;
		}

		public function set permission(value:PermissionVO):void
		{
			_permission = value;
		}


	}
}