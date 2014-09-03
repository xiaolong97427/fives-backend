package com.snj.framework.core.type;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Currency;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.type.StandardBasicTypes;
import org.hibernate.type.Type;
import org.hibernate.usertype.CompositeUserType;
import org.joda.money.BigMoney;
import org.joda.money.CurrencyUnit;

public class MoneyUserType implements CompositeUserType{

	private static final String[] PROPERTY_NAMES = {"amount", "currencyUnit"};
	private static final Type[] PROPERTY_TYPES = {StandardBasicTypes.BIG_DECIMAL, StandardBasicTypes.CURRENCY};

	public MoneyUserType()
	{
		super();
	}

	@Override
	public Object assemble(final Serializable cached, final SessionImplementor session, final Object owner)
			throws HibernateException
			{
		return cached;
			}

	@Override
	public Serializable disassemble(final Object value, final SessionImplementor session) throws HibernateException
	{
		return (Serializable) value;
	}

	@Override
	public String[] getPropertyNames()
	{
		return PROPERTY_NAMES.clone();
	}

	@Override
	public Type[] getPropertyTypes()
	{
		return PROPERTY_TYPES.clone();
	}

	@Override
	public Object getPropertyValue(final Object component, final int property) throws HibernateException
	{
		BigMoney money = (BigMoney) component;
		return (property == 0) ? money.getAmount() : money.getCurrencyUnit().toCurrency();
	}

	@Override
	public Object nullSafeGet(final ResultSet rs, final String[] names, final SessionImplementor session,
			final Object owner) throws HibernateException, SQLException
			{
		BigDecimal amount = StandardBasicTypes.BIG_DECIMAL.nullSafeGet(rs, names[0], session);
		Currency currency = StandardBasicTypes.CURRENCY.nullSafeGet(rs, names[1], session);
		return BigMoney.of(CurrencyUnit.of(currency), amount);
			}

	@Override
	public void nullSafeSet(final PreparedStatement st, final Object value, final int index,
		final SessionImplementor session) throws HibernateException, SQLException {
			BigMoney money = (BigMoney) value;
			BigDecimal amount = (money == null) ? null : money.getAmount();
			Currency currency = (money == null) ? null : money.getCurrencyUnit().toCurrency();
	
			StandardBasicTypes.BIG_DECIMAL.nullSafeSet(st, amount, index, session);
			StandardBasicTypes.CURRENCY.nullSafeSet(st, currency, index + 1, session);
		}

	@Override
	public Object replace(final Object original, final Object target, final SessionImplementor session,
			final Object owner) throws HibernateException
			{
		return deepCopy(original);
			}

	@Override
	public void setPropertyValue(final Object component, final int property, final Object value)
			throws HibernateException
			{
		throw new HibernateException("Money is immutable.");
			}

	@Override
	public Object deepCopy(final Object value) throws HibernateException
	{
		return (value != null) ? BigMoney.of(((BigMoney) value).getCurrencyUnit(),
				((BigMoney) value).getAmount()) : null;
	}

	@Override
	public boolean equals(final Object x, final Object y) throws HibernateException
	{
		//return ObjectUtils.equals(x, y);
		return x.equals(y);
	}

	@Override
	public int hashCode(final Object x) throws HibernateException
	{
		//return ObjectUtils.hashCode(x);
		return x.hashCode();
	}

	@Override
	public boolean isMutable()
	{
		return false;
	}

	@Override
	public Class<?> returnedClass()
	{
		return BigMoney.class;
	}

}
