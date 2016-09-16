var NonTerminal;
NonTerminal = "";
var Terminal;
Terminal = "";
var NullDeriving;
NullDeriving = "";

var productions;
productions={};
var first;
first={};
var follow;
follow={};
var firstResult;
firstResult={};
var followResult;
followResult={};

var input;
input = readln();
var start;
start = split(input," ");
var end;
end = start;
var i;
productions[0]=input;
i=1;

var count;
count = 1;
while(!((input = readln()) == null))
{
	productions[i]=input;
       i=i+1;
	var input1;
	input1 = split(input," ");
	count=count+1;
	end.prototype=input1;
	end=end.prototype;
}

var startNonTemrminal;
startNonTemrminal = start;
while(!(startNonTemrminal == null))
{
	NonTerminal = NonTerminal + startNonTemrminal[0]+ " ";
	startNonTemrminal = startNonTemrminal.prototype;
}

var NonTerminalResult;
NonTerminalResult = "";
var NonTerminalObject;
NonTerminalObject = split(NonTerminal," ");
var nt;
nt = 0;
while(nt<NonTerminalObject.length)
{
	if((contains(NonTerminalResult,NonTerminalObject[nt])) == false)
	{
	 NonTerminalResult = NonTerminalResult + NonTerminalObject[nt] + " ";
	}
	nt=nt+1;
}

NonTerminalObject = split(NonTerminal," ");

var startTemrminal;
startTemrminal = start;
while(!(startTemrminal == null))
{
	var counter;
	var counter1;
	var flag;
	counter = 0;
	while(counter<startTemrminal.length)
	{
		counter1 = 0;
		flag = true;
		while(counter1<NonTerminalObject.length)
		{
			if(NonTerminalObject[counter1] == startTemrminal[counter])
			{
				flag = false;
				break;
			}
			counter1=counter1+1;
		}
		if(flag)
		{
			Terminal = Terminal + startTemrminal[counter] + " ";
		}
		counter = counter+1;
	}
startTemrminal = startTemrminal.prototype;
}

var TerminalResult;
var TerminalObject;
TerminalResult = "";
TerminalObject = split(Terminal," ");
var iterm;
iterm = 0;

while(iterm<TerminalObject.length)
{
	if((contains(TerminalResult,TerminalObject[iterm])) == false)
	{
	 TerminalResult = TerminalResult + TerminalObject[iterm] + " ";
	}
	iterm=iterm+1;
}

var NullDerivingElement;
NullDerivingElement = start;
while(!(NullDerivingElement == null))
{
	var nullCounter;
	nullCounter = 0;
	while(nullCounter<NullDerivingElement.length)
	{
		if(NullDerivingElement.length == 1)
		{
			NullDeriving = NullDeriving + NullDerivingElement[nullCounter]+" ";
		}
		nullCounter = nullCounter+1;
	}
NullDerivingElement = NullDerivingElement.prototype;
}

console.log("");
console.log("Start");
console.log("");
console.log(start[0]);
console.log("");
console.log("");
console.log("Non Terminals");
console.log("");
console.log(NonTerminalResult);
console.log("");
console.log("");
console.log("Terminals");
console.log("");
console.log(TerminalResult);
console.log("");
console.log("");



var mnull;
mnull=0;
while(mnull< count )
{
	var jnull;
	jnull=0;
	while(jnull<count)
	{
		var n;
		n = split(trim(productions[jnull])," ");
		var n1;
		n1=n.length;
		var n2;
		n2 = 1;
		if(n1 > 1)
		{
			while((contains(NullDeriving,n[n2])))
			{
				if((n2+1) == n1)
				{
					if((contains(NullDeriving,n[0]))==false)
					{
					NullDeriving = NullDeriving + n[0] + " ";
					}	
				}
				if((n2+1)<n1)
				{
					n2=n2+1;
				}
				else
					break;
				
			}
		}
		jnull=jnull+1;
	}

	mnull=mnull+1;
}

console.log("Null Deriving");
console.log("");
console.log(NullDeriving);
console.log("");
console.log("");
console.log("FIRST");
console.log("");

ifirst=0;
var nfirst;
nfirst=split(NonTerminalResult," ");
countfirstobj = 0;
while(ifirst<nfirst.length)
{
first[ifirst]=nfirst[ifirst];
countfirstobj = countfirstobj +1;
ifirst=ifirst+1;
}

var ifirstterm;
ifirstterm=0;
while(ifirstterm<countfirstobj)
{
	var sfirstterm;
	sfirstterm="";
	var jfirstterm;
	jfirstterm=0;
	while(jfirstterm<count)
	{
		var n;
		n=split(productions[jfirstterm]," ");
		if(n.length > 1)
		{
	
			if(first[ifirstterm] == n[0])
			{
				if((contains(TerminalResult,n[1])))
				{
					sfirstterm=sfirstterm+n[1]+" ";
				}
			}
		}
		jfirstterm=jfirstterm+1;
	}
	first[ifirstterm]=first[ifirstterm]+" : "+sfirstterm;
	ifirstterm=ifirstterm+1;
}

var comp;
comp=0;
while(comp<count)
{
var firstNonTerm;
firstNonTerm=0;
while(firstNonTerm<countfirstobj)
{
	var firstNonTermResult;
	var temp;
	firstNonTermResult="";
	temp="";
	var jfirstNonTerm;
	jfirstNonTerm=0;
	while(jfirstNonTerm<count)
	{
		var nfirstNonTerm;
		nfirstNonTerm=split(productions[jfirstNonTerm]," ");
		if(nfirstNonTerm.length > 1)
		{
			m=split(first[firstNonTerm],":");
			x = trim(m[0]);
			if(x == nfirstNonTerm[0])
			{
				if((contains(NonTerminalResult,nfirstNonTerm[1])))
				{
					var ifirstnon;
					ifirstnon=0;
					while(ifirstnon<countfirstobj)
					{
					var afirstnon;
					var tfirstnon;
					var yfirstnon;
					afirstnon=split(first[ifirstnon],":");
					tfirstnon = trim(afirstnon[0]);
					yfirstnon = trim(nfirstNonTerm[1]);
					if(tfirstnon == yfirstnon)
					{
						break;
					}
					ifirstnon=ifirstnon+1; 
					}
					var firstslnonterm;
					firstslnonterm=split(first[ifirstnon],":");
					firstNonTermResult = trim(firstslnonterm[1]);
				}
			}
		}
		temp=temp+" "+firstNonTermResult;
		jfirstNonTerm=jfirstNonTerm+1;
	}
	if((indexOf(first[firstNonTerm],":"))==-1)
	{
	first[firstNonTerm] = first[firstNonTerm] + ":" + temp;
	}
	else
	{
	first[firstNonTerm]=first[firstNonTerm]+"  "+temp;	
	}
	firstNonTerm=firstNonTerm+1;
}
comp=comp+1;
}


var sexy;
sexy=0;
while(sexy<count)
{
var firstnull;
firstnull=0;
while(firstnull<countfirstobj)
{
	var sfirstnull;
	sfirstnull="";
	var temp1;
	temp1="";
	var tempnull;
	tempnull="";
	var jfirstnull;
	jfirstnull=0;
	while(jfirstnull<count)
	{
		var nfirstnull;
		nfirstnull=split(productions[jfirstnull]," ");
		var firstprodlength;
		firstprodlength = nfirstnull.length;
		if(nfirstnull.length > 1)
		{
			var mfirstnull;
			mfirstnull=split(first[firstnull],":");
			var xfirstnull;
			xfirstnull = trim(mfirstnull[0]);
			if(xfirstnull == nfirstnull[0])
			{
				if((contains(NonTerminalResult,nfirstnull[1])))
				{
					if((contains(NullDeriving,nfirstnull[1])))
					{
						var tfirstnull;
						tfirstnull=1;
						while((contains(NullDeriving,nfirstnull[tfirstnull])))
						{	
							
							if((tfirstnull+1)<firstprodlength)
							{
							if((contains(NonTerminalResult,nfirstnull[tfirstnull+1])))
							{
								var ifirstnull;
								ifirstnull=0;
								while(ifirstnull<countfirstobj)
								{
									var afirstNull;
									afirstNull=split(first[ifirstnull],":");
									var tsfirstNull;
									tsfirstNull = trim(afirstNull[0]);
									var yfirstNull;
									yfirstNull = trim(nfirstnull[tfirstnull+1]);
									if(tsfirstNull == yfirstNull)
									{
										break;
									}
									ifirstnull=ifirstnull+1; 								}
									var firstfirstsl;
									firstfirstsl=split(first[ifirstnull],":");
									sfirstnull = trim(firstfirstsl[1]);
									temp1=temp1+" "+sfirstnull;

							}
								
							if((contains(TerminalResult,nfirstnull[tfirstnull+1])))
							{
								firstfirstsl=split(first[ifirstnull],":");
								sfirstnull = trim(nfirstnull[tfirstnull+1]);
								temp1=temp1+" "+sfirstnull;
								break;
							}
								tfirstnull=tfirstnull+1;
							}
							else
							{
								break;
							}
						}
					}
				}
			}
		}
		tempnull=tempnull+" "+temp1;
		jfirstnull=jfirstnull+1;
	}
	if((indexOf(first[firstnull],":"))==-1)
	{
	first[firstnull] = first[firstnull] + ":" + tempnull;
	}
	else
	{
	first[firstnull]=first[firstnull]+"  "+tempnull;	
	}
	firstnull=firstnull+1;
}
sexy=sexy+1;
}


var firstlen2;
firstlen2=0;
while(firstlen2<countfirstobj)
{
	var sfirstlen2;
	sfirstlen2="";
	var jfirstlen2;
	jfirstlen2=0;
	while(jfirstlen2<count)
	{
		var nfirstlen2;
		nfirstlen2=split(productions[jfirstlen2]," ");
		if(nfirstlen2.length == 2)
		{
			var mfirstlen2;
			mfirstlen2=split(first[firstlen2],":");
			var xfirstlen2;
			xfirstlen2 = trim(mfirstlen2[0]);

			if(xfirstlen2 == nfirstlen2[0])
			{
				if((contains(NonTerminalResult,nfirstlen2[1])))
				{	
					var ifirstlen2;
					ifirstlen2=0;
					while(ifirstlen2<countfirstobj)
					{
						a=split(first[ifirstlen2],":");
						ts = trim(a[0]);
						y = trim(nfirstlen2[1]);
						if(ts == y)
						{
							break;
						}
						ifirstlen2=ifirstlen2+1; 
					}
					var firstsllen2;
					firstsllen2=split(first[ifirstlen2],":");
					sfirstlen2 = trim(firstsllen2[1]);

				}
				
			}
		}
		jfirstlen2=jfirstlen2+1;
	}
	if((indexOf(first[firstlen2],":")) == -1)
	{
	first[firstlen2] = first[firstlen2] + ":" + sfirstlen2;
	}
	else
	{
	first[firstlen2]=first[firstlen2]+"  "+sfirstlen2;	
	}

	firstlen2=firstlen2+1;
}


var resfirst;
resfirst = 0;
while(resfirst<countfirstobj)
{
var nfirstres;
nfirstres=split(first[resfirst],":");
firstResult[resfirst] = nfirstres[0] + " " +":"+" ";
hmmfirstres = split(nfirstres[1]," ");
var ifirstres;
ifirstres=0;
while(ifirstres<hmmfirstres.length)
{
	if((contains(firstResult[resfirst],hmmfirstres[ifirstres]))==false)
	{
		firstResult[resfirst]=firstResult[resfirst]+hmmfirstres[ifirstres]+" ";	
	}
 	ifirstres=ifirstres+1;
}
console.log(firstResult[resfirst]);
console.log("");
resfirst=resfirst+1;
}



console.log("FOLLOW");
console.log("");

var ifollow;
ifollow=0;
var nfollow;
nfollow=split(NonTerminalResult," ");
while(ifollow<nfollow.length)
{
follow[ifollow]=nfollow[ifollow];
ifollow=ifollow+1;
}

var ieo;
ieo=0;
while(ieo<countfirstobj)
{
	var x;
	var y;
	x=trim(follow[ieo]);
	y=trim(start[0]);
	if(x==y)
	{
		follow[ieo]=follow[ieo]+" : "+"EOF"+" ";
	}
	ieo=ieo+1;
}

var kfollow;
kfollow=0;
while(kfollow<countfirstobj)
{
	var sfollow;
	var jfollow;
	var temp;
	var temp1;
	sfollow="";
	jfollow=0;
	temp="";
	temp1="";
	while(jfollow<count)
	{
		var nfollow;
		nfollow=split(productions[jfollow]," ");
		if(nfollow.length > 1)
		{
			var x;
			x=1;
			while(x<nfollow.length)
			{
				fol = split(follow[kfollow],":");
				xfol=trim(fol[0]);
				
				if(xfol == nfollow[x])
				{
					if(!((x+1)==nfollow.length))
					{
					
						if((contains(TerminalResult,nfollow[x+1])))
						{
							sfollow=sfollow+" "+nfollow[x+1]+" ";
							temp1=sfollow;
						}
						
						if((contains(NonTerminalResult,nfollow[x+1])))
						{
							var infollow;
							infollow=0;
							while(infollow<countfirstobj)
							{
								var anfollow;
								var tsnfollow;
								var ynfollow;
								anfollow=split(follow[infollow],":");
								tsnfollow = trim(anfollow[0]);
								ynfollow = trim(nfollow[x+1]);
								if(tsnfollow == ynfollow)
								{
									break;
								}
								infollow=infollow+1; 
							}
							firstsl=split(first[infollow],":");
							sfollow = trim(firstsl[1]);
							temp1=temp1+" "+sfollow;
							
						}
					}
				}
				x=x+1;
			}
			
		}
		temp=temp+" "+temp1;
		jfollow=jfollow+1;
	}
	if((indexOf(follow[kfollow],":"))==-1)
	{
			follow[kfollow] = follow[kfollow] + " : " + temp;
	}
	else
	{
			follow[kfollow]=follow[kfollow]+"  "+temp;
	}
	kfollow=kfollow+1;
}


var kfollownull;
kfollownull=0;
var flag;
flag=false;
while(kfollownull<countfirstobj)
{
	var sfollownull;
	sfollownull="";
	var jfollownull;
	jfollownull=0;
	var tempfollownull;
	tempfollownull="";
	var temp1follownull;
	temp1follownull=""; 
	while(jfollownull<count)
	{
		var nfollownull;
		nfollownull=split(productions[jfollownull]," ");
		var prodlength;
		prodlength = nfollownull.length;
		if(nfollownull.length > 2)
		{
			var xfollownull;
			xfollownull=1;
			while(xfollownull<nfollownull.length)
			{
				var folnull;
				var xfolnull;
				folnull = split(follow[kfollownull],":");
				xfolnull=trim(folnull[0]);
				if(xfolnull == nfollownull[xfollownull])
				{
					if(!((xfollownull+1)==nfollownull.length))
					{
						if((contains(NonTerminalResult,nfollownull[xfollownull+1])))
						{
							if((contains(NullDeriving,nfollownull[xfollownull+1])))
							{
								tnull=xfollownull+1;
								while((contains(NullDeriving,nfollownull[tnull])))
								{	
									if((tnull+1)==prodlength)
									{
										flag=true;
										break;
									}
									else
									{
										if((contains(NonTerminalResult,nfollownull[tnull+1])))
										{
											var ifollownull1;
											ifollownull1=0;
											while(ifollownull1<countfirstobj)
											{
												var a;
												var ts;
												var y;
												a=split(follow[ifollownull1],":");
												ts = trim(a[0]);
												y = trim(nfollownull[tnull+1]);
												if(ts == y)
												{
													break;
												}
												ifollownull1=ifollownull1+1;
											}
											firstsl = split(first[ifollownull1],":");
											sfollownull=trim(firstsl[1]);
											temp1follownull=temp1follownull+" "+sfollownull;

										}	
										if((contains(TerminalResult,nfollownull[tnull+1])))
										{
											sfollownull=trim(nfollownull[tnull+1]);
											temp1follownull=temp1follownull+" "+sfollownull;	
										}

										if((tnull+1)<prodlength)
										{
											tnull=tnull+1;
										}
										else
										{
											break;
										}
										
									}
								}	
							}
						}						
					}
					
				}
				xfollownull=xfollownull+1;
			}

		}
		if(flag)
		{
			var ifollownull;
			ifollownull=0;
			var a;
			var ts;
			var y;
			while(ifollownull<countfirstobj)
			{
				a=split(follow[ifollownull],":");
				ts = trim(a[0]);
				y = trim(nfollownull[0]);
				if(ts == y)
				{
					break;
				}
				ifollownull=ifollownull+1;
			}
		 	temp1follownull=temp1follownull+" "+a[1]+" ";
		 	flag=false;	
		}
		tempfollownull=tempfollownull+" "+temp1follownull;
		jfollownull=jfollownull+1;
	}

	if((indexOf(follow[kfollownull],":"))==-1)
	{
			follow[kfollownull] = follow[kfollownull] + " : " + tempfollownull;
	}
	else
	{
			follow[kfollownull]=follow[kfollownull]+"  "+tempfollownull;
	}

	kfollownull=kfollownull+1;
}


var kfollowlen2;
kfollowlen2=0;
while(kfollowlen2<countfirstobj)
{
	var sfollowlen2;
	sfollowlen2="";
	var jfollowlen2;
	jfollowlen2=0;
	while(jfollowlen2<count)
	{
		var nfollowlen2;
		nfollowlen2=split(productions[jfollowlen2]," ");
		if(nfollowlen2.length == 2)
		{
			var mfollowlen2;
			var xfollowlen2;
			mfollowlen2=split(follow[kfollowlen2],":");
			xfollowlen2 = trim(mfollowlen2[0]);
			
			if(xfollowlen2 == nfollowlen2[1])
			{
				if((contains(NonTerminalResult,nfollowlen2[1])))
				{	
						var ifollowlen2;
						ifollowlen2=0;
						while(ifollowlen2<countfirstobj)
						{
							var afollowlen2;
							afollowlen2=split(follow[ifollowlen2],":");
							ts = trim(afollowlen2[0]);
							y = trim(nfollowlen2[0]);
							if(ts == y)
							{
								break;
							}
							ifollowlen2=ifollowlen2+1; 
						}
					firstsl=split(follow[ifollowlen2],":");
					sfollowlen2 = trim(firstsl[1]);
				}
			}
		}
		jfollowlen2=jfollowlen2+1;
	}
	if((indexOf(follow[kfollowlen2],":")) == -1)
	{
	follow[kfollowlen2] = follow[kfollowlen2] + ":" + sfollowlen2;
	}
	else
	{
	follow[kfollowlen2]=follow[kfollowlen2]+"  "+sfollowlen2;	
	}
	kfollowlen2=kfollowlen2+1;
}

var klastfollow;
klastfollow=0;
while(klastfollow<countfirstobj)
{
	var slastfollow;
	slastfollow="";
	var jlastfollow;
	jlastfollow=0;
	while(jlastfollow<count)
	{
		var nlastfollow;
		nlastfollow=split(productions[jlastfollow]," ");
		length = nlastfollow.length;
		if(nlastfollow.length > 2)
		{
			var mlastfollow;
			var xlastfollow;
			mlastfollow=split(follow[klastfollow],":");
			xlastfollow = trim(mlastfollow[0]);
			
			if(xlastfollow == nlastfollow[length-1])
			{
				if((contains(NonTerminalResult,nlastfollow[length-1])))
				{	
						var ilastfollow;
						ilastfollow=0;
						while(ilastfollow<countfirstobj)
						{
							var a;
							var ts;
							var y;
							a=split(follow[ilastfollow],":");
							ts = trim(a[0]);
							y = trim(nlastfollow[0]);
							if(ts == y)
							{
								break;
							}
							ilastfollow=ilastfollow+1; 
						}
					firstsl=split(follow[ilastfollow],":");
					slastfollow = trim(firstsl[1]);
				}
			}
		}
		jlastfollow=jlastfollow+1;
	}
	if((indexOf(follow[klastfollow],":")) == -1)
	{
	follow[klastfollow] = follow[klastfollow] + ":" + slastfollow;
	}
	else
	{
	follow[klastfollow]=follow[klastfollow]+"  "+slastfollow;	
	}
	klastfollow=klastfollow+1;
}



var followres;
followres=0;
while(followres<countfirstobj)
{
var nfollowres;
nfollowres=split(follow[followres],":");
followResult[followres] = nfollowres[0]+" "+":"+" ";
hmm = split(nfollowres[1]," ");
var i;
i=0;
while(i<hmm.length)
{
	if((contains(followResult[followres],hmm[i]))==false)
	{
		followResult[followres]=followResult[followres]+hmm[i]+" ";	
	}
 	i=i+1;
}
console.log(followResult[followres]);
console.log("");
followres=followres+1;
}

console.log("PREDICT SETS");
console.log("");

var jpredict;
jpredict=0;
while(jpredict<count)
{
 console.log(productions[jpredict]);
 var npredict;
 npredict=split(productions[jpredict]," ");
 var spredict;
 spredict="";
 var temp;
 temp="";
 	if(npredict.length==1)
 	{
		var ipredict;
		ipredict=0;
		while(ipredict<countfirstobj)
		{
			var apredict2;
			var tspredict2;
			var ypredict2;
			apredict2=split(follow[ipredict],":");
			tspredict2 = trim(apredict2[0]);
			ypredict2 = trim(npredict[0]);
			if(tspredict2 == ypredict2)
			{
				break;
			}
		ipredict=ipredict+1; 
		}
	var firstslpredict1;
	firstslpredict1=split(followResult[ipredict],":");
	spredict=trim(firstslpredict1[1]);
	console.log(spredict);
	}
	
	if(npredict.length>1)
	{
		var tpredict;
		tpredict=1;
		if((contains(NonTerminalResult,npredict[1])))
		{
			var ipredict2;
			ipredict2=0;
			while(ipredict2<countfirstobj)
			{
				var apredict;
				var tspredict;
				var ypredict;
				apredict=split(follow[ipredict2],":");
				tspredict = trim(apredict[0]);
				ypredict = trim(npredict[1]);
				if(tspredict == ypredict)
				{
					break;
				}
			ipredict2=ipredict2+1; 
			}
			firstsl=split(firstResult[ipredict2],":");
			spredict=trim(firstsl[1]);
			console.log(spredict);
			temp=temp+" "+spredict;

		}
		if((contains(TerminalResult,npredict[1])))
		{
			spredict=trim(npredict[1]);
			console.log(spredict);
		}
		if((tpredict+1)<npredict.length)
		{
			if((contains(NonTerminalResult,npredict[tpredict])))
			{
				while((contains(NullDeriving,npredict[tpredict])))
				{
					if(!((tpredict+1)==npredict.length))
					{
						if((contains(NonTerminalResult,npredict[tpredict+1])))
						{
							var ipredict3;
							ipredict3=0;
							while(ipredict3<countfirstobj)
							{
								var apredict3;
								var tpredict3;
								var ypredict3;
								apredict3=split(follow[ipredict3],":");
								tpredict3=trim(apredict3[0]);
								ypredict3=trim(npredict[tpredict+1]);
								if(tpredict3==ypredict3)
								{
									break;
								}
								ipredict3=ipredict3+1;
							}							
							firstsl=split(firstResult[ipredict3],":");
							spredict=trim(firstsl[1]);
							console.log(spredict);	
						}
						if((contains(TerminalResult,npredict[tpredict+1])))
						{
							spredict = npredict[tpredict+1];
							console.log(spredict);
						}
					}
					if((tpredict+1)<npredict.length)
					{
						tpredict=tpredict+1;
					}
					else
					{
						break;
					}
				}
				
			}
		}
	}
 console.log("");
 console.log("");
 jpredict=jpredict+1;
}