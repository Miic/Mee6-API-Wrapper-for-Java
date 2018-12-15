/* 
Licensed to the Apache Software Foundation (ASF) under one
or more contributor license agreements.  See the NOTICE file
distributed with this work for additional information
regarding copyright ownership.  The ASF licenses this file
to you under the Apache License, Version 2.0 (the
"License"); you may not use this file except in compliance
with the License.  You may obtain a copy of the License at

  http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing,
software distributed under the License is distributed on an
"AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
KIND, either express or implied.  See the License for the
specific language governing permissions and limitations
under the License.
*/

package com.elyssiamc.Micc.JavaMee6APIWrapper.DataStructures.Adapters;

/**
 * Auto-generated code used to translate Guild a JSON Response to a Java object
 * 
 * @author Micc
 *
 */
public class ErrorMessage {
	  Error ErrorObject;
	  private float status_code;


	 // Getter Methods 

	  public Error getError() {
	    return ErrorObject;
	  }

	  public float getStatus_code() {
	    return status_code;
	  }

	 // Setter Methods 

	  public void setError( Error errorObject ) {
	    this.ErrorObject = errorObject;
	  }

	  public void setStatus_code( float status_code ) {
	    this.status_code = status_code;
	  }
	  
	  
	  public class Error {
		  private String message;
		  
		 // Getter Methods 
		  public String getMessage() {
		    return message;
		  }

		 // Setter Methods 
		  public void setMessage( String message ) {
		    this.message = message;
		  }
		}
}

