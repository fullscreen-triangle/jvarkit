/*
The MIT License (MIT)

Copyright (c) 2019 Pierre Lindenbaum

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.

*/
package com.github.lindenb.jvarkit.pedigree;

import java.util.Set;

/* a collection of samples */
public interface SampleSet {
	/** return the samples in this SampleSet */
	public Set<Sample> getSamples();
	/** find a sample in this SampleSet . returns the sample with this id or null if not found */
	public default Sample getSampleById(final String id) {
		if(id==null) return null;
		Sample ret = null;
		for(final Sample sample: this. getSamples())
			{
			if(!id.equals(sample.getId()) ) continue;
			if(ret!=null) throw new IllegalStateException("ambigous sample id "+id+" found twice "+ret+" and "+ sample);
			ret = sample;
			}
		return ret;
		}
	/** return all the trios in this SampleSet */
	public Set<Trio> getTrios() {
		return this. getSamples().
			stream().
			filter(S->sample.hasFather() || sample.hasMother()).
			map(S->new TrioImpl(sample)).
			collect(Collectors.toSet());
		}
	}
